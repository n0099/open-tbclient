package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.R;
import com.baidu.tieba.video.ActivityItemData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.Agree;
import tbclient.Media;
import tbclient.OriginThreadInfo;
import tbclient.PbContent;
import tbclient.User;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class OriginalThreadInfo {
    public Agree agree;
    public User author;
    public boolean cOY = false;
    public ArrayList<MediaData> cPU;
    public List<AbstractData> cPV;
    public AlaInfoData cPW;
    public boolean cPX;
    public ArrayList<VoiceData.VoiceModel> cPY;
    public SpannableString cPZ;
    public boolean cQa;
    public List<PbContent> content;
    public long forumId;
    public String forumName;
    public BaijiahaoData oriUgcInfo;
    public String postId;
    public Integer reply_num;
    public Integer shared_num;
    public String showPicUrl;
    public String showText;
    public int showType;
    public String threadId;
    public int threadType;
    public String title;
    public String videoId;
    public VideoInfo videoInfo;

    public void a(OriginThreadInfo originThreadInfo) {
        if (originThreadInfo == null) {
            aBa();
            return;
        }
        this.forumName = originThreadInfo.fname;
        this.forumId = originThreadInfo.fid.longValue();
        this.threadId = originThreadInfo.tid;
        this.title = originThreadInfo.title;
        this.threadType = originThreadInfo.thread_type.intValue();
        this.content = originThreadInfo.content;
        this.author = originThreadInfo.author;
        this.agree = originThreadInfo.agree;
        this.reply_num = originThreadInfo.reply_num;
        this.shared_num = originThreadInfo.shared_num;
        if (!com.baidu.tbadk.core.util.v.isEmpty(originThreadInfo.media)) {
            this.cPU = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.cPU.add(mediaData);
                }
            }
        } else {
            this.cPU = null;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(originThreadInfo._abstract)) {
            this.cPV = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.cPV.add(abstractData);
                }
            }
        } else {
            this.cPV = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.cPW = new AlaInfoData();
            this.cPW.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.cPW = null;
        }
        this.cOY = originThreadInfo.is_deleted.intValue() == 1;
        this.cPX = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.cQa = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.cPY = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.cPY.add(voiceModel);
            }
        }
        aBc();
        aAY();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            aBa();
            return;
        }
        try {
            this.forumName = jSONObject.optString("fname");
            this.forumId = jSONObject.optLong("fid", 0L);
            this.threadId = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.threadType = jSONObject.optInt("thread_type");
            this.content = aq.N(jSONObject.optJSONArray("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.cPW = new AlaInfoData();
                this.cPW.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.cPU = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.cPU.add(mediaData);
                }
            } else {
                this.cPU = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.cPV = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.cPV.add(abstractData);
                }
            } else {
                this.cPV = null;
            }
            this.cOY = jSONObject.optInt("is_deleted") == 1;
            this.cPX = jSONObject.optInt("is_ugc") == 1;
            this.cQa = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = bs.ck(jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.cPY = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.cPY.add(voiceModel);
                }
            }
            aAY();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                aBc();
            }
        }
    }

    private void aAY() {
        this.cPZ = new SpannableString(com.baidu.tbadk.widget.richText.e.aO(this.content));
    }

    public static OriginalThreadInfo r(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.cUe != null) {
            return bjVar.cUe;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bjVar.aCw();
        originalThreadInfo.forumId = bjVar.getFid();
        originalThreadInfo.threadId = bjVar.getTid();
        originalThreadInfo.title = bjVar.getTitle();
        originalThreadInfo.threadType = bjVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bjVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.cPV = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.cPU = arrayList2;
        originalThreadInfo.videoInfo = bjVar.aCI();
        if (bjVar.isLinkThread() && bjVar.aDR() != null) {
            ag aDR = bjVar.aDR();
            originalThreadInfo.title = aDR.aAQ();
            abstractData.text = aDR.aAR();
            mediaData.setPic(aDR.aAS());
        } else if (bjVar.aDv() && bjVar.aBX() != null) {
            mediaData.setPic(bjVar.aBX().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.v.getCount(bjVar.aCB()) > 0) {
            originalThreadInfo.cPU = bjVar.aCB();
        } else if (bjVar.aCI() != null && !StringUtils.isNull(bjVar.aCI().thumbnail_url)) {
            mediaData.setPic(bjVar.aCI().thumbnail_url);
        }
        originalThreadInfo.cPW = bjVar.aCK();
        originalThreadInfo.aBc();
        originalThreadInfo.oriUgcInfo = bjVar.getBaijiahaoData();
        return originalThreadInfo;
    }

    public bj aAZ() {
        bj bjVar = new bj();
        bjVar.setTitle(this.title);
        if (this.cPU != null) {
            bjVar.z(new ArrayList<>(this.cPU));
        }
        bjVar.sG(this.forumName);
        bjVar.setTid(this.threadId);
        bjVar.a(this.cPW);
        bjVar.setFid(this.forumId);
        bjVar.setThreadType(this.threadType);
        bjVar.isShareThread = true;
        bjVar.setBaijiahaoData(this.oriUgcInfo);
        bjVar.a(this.videoInfo);
        bjVar.sO(this.showPicUrl);
        bjVar.cUe = this;
        return bjVar;
    }

    private void aBa() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean aBb() {
        return this.cQa;
    }

    public void aBc() {
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
        if (com.baidu.tbadk.core.util.v.getItem(this.cPU, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.cPU, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.cPU, 0)).getPicUrl();
            }
        }
        if (StringUtils.isNull(this.showPicUrl) && this.videoInfo != null) {
            this.showPicUrl = this.videoInfo.thumbnail_url;
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
        } else if (com.baidu.tbadk.core.util.v.getItem(this.cPV, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cPV, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cPV, 0)).text;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData aBd() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aBe() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.vN(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean aBe() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String aBf() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.v.getItem(this.cPV, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cPV, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cPV, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean aBg() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean aBh() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 2;
    }

    /* loaded from: classes.dex */
    public static class ShareInfo extends OrmObject implements Serializable {
        public BaijiahaoData oriUgcInfo;
        public String showPicUrl;
        public String showText;
        public int showType;
        public String threadId;
        public String videoId;

        public static ShareInfo generateShareInfo(OriginalThreadInfo originalThreadInfo) {
            ShareInfo shareInfo = new ShareInfo();
            shareInfo.threadId = originalThreadInfo.threadId;
            shareInfo.showType = originalThreadInfo.showType;
            shareInfo.showText = originalThreadInfo.showText;
            shareInfo.showPicUrl = originalThreadInfo.showPicUrl;
            shareInfo.videoId = originalThreadInfo.videoId;
            shareInfo.oriUgcInfo = originalThreadInfo.oriUgcInfo;
            return shareInfo;
        }

        public static ShareInfo generateShareInfo(bj bjVar) {
            return generateShareInfo(OriginalThreadInfo.r(bjVar));
        }
    }
}
