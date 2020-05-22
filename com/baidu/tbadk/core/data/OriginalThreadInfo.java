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
    public List<PbContent> content;
    public boolean dCi = false;
    public ArrayList<MediaData> dDc;
    public List<AbstractData> dDd;
    public AlaInfoData dDe;
    public boolean dDf;
    public ArrayList<VoiceData.VoiceModel> dDg;
    public SpannableString dDh;
    public boolean dDi;
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
            aPg();
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
            this.dDc = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dDc.add(mediaData);
                }
            }
        } else {
            this.dDc = null;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(originThreadInfo._abstract)) {
            this.dDd = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.dDd.add(abstractData);
                }
            }
        } else {
            this.dDd = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.dDe = new AlaInfoData();
            this.dDe.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.dDe = null;
        }
        this.dCi = originThreadInfo.is_deleted.intValue() == 1;
        this.dDf = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.dDi = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.dDg = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.dDg.add(voiceModel);
            }
        }
        aPi();
        aPe();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            aPg();
            return;
        }
        try {
            this.forumName = jSONObject.optString("fname");
            this.forumId = jSONObject.optLong("fid", 0L);
            this.threadId = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.threadType = jSONObject.optInt("thread_type");
            this.content = ap.N(jSONObject.optJSONArray("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.dDe = new AlaInfoData();
                this.dDe.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.dDc = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.dDc.add(mediaData);
                }
            } else {
                this.dDc = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.dDd = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.dDd.add(abstractData);
                }
            } else {
                this.dDd = null;
            }
            this.dCi = jSONObject.optInt("is_deleted") == 1;
            this.dDf = jSONObject.optInt("is_ugc") == 1;
            this.dDi = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = bt.cB(jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.dDg = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.dDg.add(voiceModel);
                }
            }
            aPe();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                aPi();
            }
        }
    }

    private void aPe() {
        this.dDh = new SpannableString(com.baidu.tbadk.widget.richText.e.aT(this.content));
    }

    public static OriginalThreadInfo s(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        if (bkVar.dHm != null) {
            return bkVar.dHm;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bkVar.aQC();
        originalThreadInfo.forumId = bkVar.getFid();
        originalThreadInfo.threadId = bkVar.getTid();
        originalThreadInfo.title = bkVar.getTitle();
        originalThreadInfo.threadType = bkVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bkVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.dDd = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.dDc = arrayList2;
        originalThreadInfo.videoInfo = bkVar.aQQ();
        if (bkVar.isLinkThread() && bkVar.aSc() != null) {
            af aSc = bkVar.aSc();
            originalThreadInfo.title = aSc.aOW();
            abstractData.text = aSc.aOX();
            mediaData.setPic(aSc.aOY());
        } else if (bkVar.aRF() && bkVar.aQd() != null) {
            mediaData.setPic(bkVar.aQd().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.v.getCount(bkVar.aQH()) > 0) {
            originalThreadInfo.dDc = bkVar.aQH();
        } else if (bkVar.aQQ() != null && !StringUtils.isNull(bkVar.aQQ().thumbnail_url)) {
            mediaData.setPic(bkVar.aQQ().thumbnail_url);
        }
        originalThreadInfo.dDe = bkVar.aQS();
        originalThreadInfo.aPi();
        originalThreadInfo.oriUgcInfo = bkVar.getBaijiahaoData();
        return originalThreadInfo;
    }

    public bk aPf() {
        bk bkVar = new bk();
        bkVar.setTitle(this.title);
        if (this.dDc != null) {
            bkVar.z(new ArrayList<>(this.dDc));
        }
        bkVar.vC(this.forumName);
        bkVar.setTid(this.threadId);
        bkVar.a(this.dDe);
        bkVar.setFid(this.forumId);
        bkVar.setThreadType(this.threadType);
        bkVar.isShareThread = true;
        bkVar.setBaijiahaoData(this.oriUgcInfo);
        bkVar.a(this.videoInfo);
        bkVar.vK(this.showPicUrl);
        bkVar.dHm = this;
        return bkVar;
    }

    private void aPg() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean aPh() {
        return this.dDi;
    }

    public void aPi() {
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
        if (com.baidu.tbadk.core.util.v.getItem(this.dDc, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.dDc, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.dDc, 0)).getPicUrl();
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
        } else if (com.baidu.tbadk.core.util.v.getItem(this.dDd, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dDd, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dDd, 0)).text;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData aPj() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aPk() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.yL(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean aPk() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String aPl() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.v.getItem(this.dDd, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dDd, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dDd, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean aPm() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean aPn() {
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

        public static ShareInfo generateShareInfo(bk bkVar) {
            return generateShareInfo(OriginalThreadInfo.s(bkVar));
        }
    }
}
