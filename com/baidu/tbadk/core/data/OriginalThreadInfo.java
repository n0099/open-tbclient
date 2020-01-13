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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.Media;
import tbclient.OriginThreadInfo;
import tbclient.PbContent;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class OriginalThreadInfo {
    public boolean cKG = false;
    public ArrayList<MediaData> cLC;
    public List<AbstractData> cLD;
    public AlaInfoData cLE;
    public boolean cLF;
    public ArrayList<VoiceData.VoiceModel> cLG;
    public SpannableString cLH;
    public boolean cLI;
    public List<PbContent> content;
    public long forumId;
    public String forumName;
    public BaijiahaoData oriUgcInfo;
    public String postId;
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
            ayH();
            return;
        }
        this.forumName = originThreadInfo.fname;
        this.forumId = originThreadInfo.fid.longValue();
        this.threadId = originThreadInfo.tid;
        this.title = originThreadInfo.title;
        this.threadType = originThreadInfo.thread_type.intValue();
        this.content = originThreadInfo.content;
        if (!com.baidu.tbadk.core.util.v.isEmpty(originThreadInfo.media)) {
            this.cLC = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.cLC.add(mediaData);
                }
            }
        } else {
            this.cLC = null;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(originThreadInfo._abstract)) {
            this.cLD = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.cLD.add(abstractData);
                }
            }
        } else {
            this.cLD = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.cLE = new AlaInfoData();
            this.cLE.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.cLE = null;
        }
        this.cKG = originThreadInfo.is_deleted.intValue() == 1;
        this.cLF = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.cLI = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.cLG = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.cLG.add(voiceModel);
            }
        }
        ayJ();
        ayF();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            ayH();
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
                this.cLE = new AlaInfoData();
                this.cLE.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.cLC = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.cLC.add(mediaData);
                }
            } else {
                this.cLC = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.cLD = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.cLD.add(abstractData);
                }
            } else {
                this.cLD = null;
            }
            this.cKG = jSONObject.optInt("is_deleted") == 1;
            this.cLF = jSONObject.optInt("is_ugc") == 1;
            this.cLI = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = bs.ck(jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.cLG = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.cLG.add(voiceModel);
                }
            }
            ayF();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                ayJ();
            }
        }
    }

    private void ayF() {
        this.cLH = new SpannableString(com.baidu.tbadk.widget.richText.e.aO(this.content));
    }

    public static OriginalThreadInfo r(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.cPN != null) {
            return bjVar.cPN;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bjVar.aAc();
        originalThreadInfo.forumId = bjVar.getFid();
        originalThreadInfo.threadId = bjVar.getTid();
        originalThreadInfo.title = bjVar.getTitle();
        originalThreadInfo.threadType = bjVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bjVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.cLD = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.cLC = arrayList2;
        originalThreadInfo.videoInfo = bjVar.aAo();
        if (bjVar.isLinkThread() && bjVar.aBy() != null) {
            ag aBy = bjVar.aBy();
            originalThreadInfo.title = aBy.ayx();
            abstractData.text = aBy.ayy();
            mediaData.setPic(aBy.ayz());
        } else if (bjVar.aBc() && bjVar.azC() != null) {
            mediaData.setPic(bjVar.azC().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.v.getCount(bjVar.aAh()) > 0) {
            originalThreadInfo.cLC = bjVar.aAh();
        } else if (bjVar.aAo() != null && !StringUtils.isNull(bjVar.aAo().thumbnail_url)) {
            mediaData.setPic(bjVar.aAo().thumbnail_url);
        }
        originalThreadInfo.cLE = bjVar.aAq();
        originalThreadInfo.ayJ();
        originalThreadInfo.oriUgcInfo = bjVar.getBaijiahaoData();
        return originalThreadInfo;
    }

    public bj ayG() {
        bj bjVar = new bj();
        bjVar.setTitle(this.title);
        if (this.cLC != null) {
            bjVar.x(new ArrayList<>(this.cLC));
        }
        bjVar.sp(this.forumName);
        bjVar.setTid(this.threadId);
        bjVar.a(this.cLE);
        bjVar.setFid(this.forumId);
        bjVar.setThreadType(this.threadType);
        bjVar.isShareThread = true;
        bjVar.setBaijiahaoData(this.oriUgcInfo);
        bjVar.a(this.videoInfo);
        bjVar.sy(this.showPicUrl);
        bjVar.cPN = this;
        return bjVar;
    }

    private void ayH() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean ayI() {
        return this.cLI;
    }

    public void ayJ() {
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
        if (com.baidu.tbadk.core.util.v.getItem(this.cLC, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.cLC, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.cLC, 0)).getPicUrl();
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
        } else if (com.baidu.tbadk.core.util.v.getItem(this.cLD, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cLD, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cLD, 0)).text;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public String ayK() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.v.getItem(this.cLD, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cLD, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.cLD, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean ayL() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
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
