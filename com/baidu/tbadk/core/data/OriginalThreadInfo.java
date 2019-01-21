package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.Media;
import tbclient.OriginThreadInfo;
/* loaded from: classes.dex */
public class OriginalThreadInfo extends OrmObject implements Serializable {
    public static final int TYPE_ALA_LIVE = 4;
    public static final int TYPE_LINK = 2;
    public static final int TYPE_TEXT_AND_PIC = 1;
    public static final int TYPE_TEXT_OR_DEFAULT = 0;
    public static final int TYPE_VIDEO = 3;
    public List<AbstractData> abstractList;
    public AlaInfoData alaInfoData;
    public long forumId;
    public String forumName;
    public boolean isDeleted = false;
    public List<MediaData> mediaList;
    public String postId;
    public String showPicUrl;
    public String showText;
    public int showType;
    public String threadId;
    public int threadType;
    public String title;
    public String videoId;

    public void parser(OriginThreadInfo originThreadInfo) {
        if (originThreadInfo == null) {
            yW();
            return;
        }
        this.forumName = originThreadInfo.fname;
        this.forumId = originThreadInfo.fid.longValue();
        this.threadId = originThreadInfo.tid;
        this.title = originThreadInfo.title;
        this.threadType = originThreadInfo.thread_type.intValue();
        if (!com.baidu.tbadk.core.util.v.I(originThreadInfo.media)) {
            this.mediaList = new ArrayList();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.mediaList.add(mediaData);
                }
            }
        } else {
            this.mediaList = null;
        }
        if (!com.baidu.tbadk.core.util.v.I(originThreadInfo._abstract)) {
            this.abstractList = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.abstractList.add(abstractData);
                }
            }
        } else {
            this.abstractList = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.alaInfoData = new AlaInfoData();
            this.alaInfoData.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.alaInfoData = null;
        }
        this.isDeleted = originThreadInfo.is_deleted.intValue() == 1;
        setShowData();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            yW();
            return;
        }
        try {
            this.forumName = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
            this.forumId = jSONObject.optLong(ImageViewerConfig.FORUM_ID, 0L);
            this.threadId = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.threadType = jSONObject.optInt("thread_type");
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.alaInfoData = new AlaInfoData();
                this.alaInfoData.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.mediaList = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.mediaList.add(mediaData);
                }
            } else {
                this.mediaList = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.abstractList = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.abstractList.add(abstractData);
                }
            } else {
                this.abstractList = null;
            }
            this.isDeleted = jSONObject.optInt("is_deleted") == 1;
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                setShowData();
            }
        }
    }

    public static OriginalThreadInfo parseFromThreadData(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        if (bbVar.avW != null) {
            return bbVar.avW;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bbVar.zZ();
        originalThreadInfo.forumId = bbVar.getFid();
        originalThreadInfo.threadId = bbVar.getTid();
        originalThreadInfo.title = bbVar.getTitle();
        originalThreadInfo.threadType = bbVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bbVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.abstractList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.mediaList = arrayList2;
        if (bbVar.isLinkThread() && bbVar.Bl() != null) {
            ad Bl = bbVar.Bl();
            originalThreadInfo.title = Bl.yM();
            abstractData.text = Bl.yN();
            mediaData.setPic(Bl.yO());
        } else if (bbVar.AK() && bbVar.zA() != null) {
            mediaData.setPic(bbVar.zA().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.v.H(bbVar.Ae()) > 0) {
            originalThreadInfo.mediaList = bbVar.Ae();
        } else if (bbVar.Al() != null && !StringUtils.isNull(bbVar.Al().thumbnail_url)) {
            mediaData.setPic(bbVar.Al().thumbnail_url);
        }
        originalThreadInfo.alaInfoData = bbVar.An();
        originalThreadInfo.setShowData();
        return originalThreadInfo;
    }

    private void yW() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(e.j.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public void setShowData() {
        switch (this.threadType) {
            case 40:
                this.showType = 3;
                break;
            case 49:
            case 50:
            case 60:
                this.showType = 4;
                break;
            case 54:
                this.showType = 2;
                break;
            default:
                this.showType = 0;
                break;
        }
        if (com.baidu.tbadk.core.util.v.d(this.mediaList, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.d(this.mediaList, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.d(this.mediaList, 0)).getPicUrl();
            }
        }
        if (this.showType == 0) {
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showType = 0;
            } else {
                this.showType = 1;
            }
        }
        if (!StringUtils.isNull(this.title)) {
            this.showText = this.title;
        } else if (com.baidu.tbadk.core.util.v.d(this.abstractList, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.d(this.abstractList, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.v.d(this.abstractList, 0)).text;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(e.j.original_thread_default_txt);
        }
    }
}
