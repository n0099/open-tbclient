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
    public boolean doe = false;
    public ArrayList<MediaData> dpa;
    public List<AbstractData> dpb;
    public AlaInfoData dpc;
    public boolean dpd;
    public ArrayList<VoiceData.VoiceModel> dpe;
    public SpannableString dpf;
    public boolean dpg;
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
            aJn();
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
            this.dpa = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dpa.add(mediaData);
                }
            }
        } else {
            this.dpa = null;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(originThreadInfo._abstract)) {
            this.dpb = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.dpb.add(abstractData);
                }
            }
        } else {
            this.dpb = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.dpc = new AlaInfoData();
            this.dpc.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.dpc = null;
        }
        this.doe = originThreadInfo.is_deleted.intValue() == 1;
        this.dpd = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.dpg = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.dpe = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.dpe.add(voiceModel);
            }
        }
        aJp();
        aJl();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            aJn();
            return;
        }
        try {
            this.forumName = jSONObject.optString("fname");
            this.forumId = jSONObject.optLong("fid", 0L);
            this.threadId = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.threadType = jSONObject.optInt("thread_type");
            this.content = aq.O(jSONObject.optJSONArray("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.dpc = new AlaInfoData();
                this.dpc.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.dpa = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.dpa.add(mediaData);
                }
            } else {
                this.dpa = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.dpb = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.dpb.add(abstractData);
                }
            } else {
                this.dpb = null;
            }
            this.doe = jSONObject.optInt("is_deleted") == 1;
            this.dpd = jSONObject.optInt("is_ugc") == 1;
            this.dpg = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = bs.cv(jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.dpe = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.dpe.add(voiceModel);
                }
            }
            aJl();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                aJp();
            }
        }
    }

    private void aJl() {
        this.dpf = new SpannableString(com.baidu.tbadk.widget.richText.e.aY(this.content));
    }

    public static OriginalThreadInfo r(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.dto != null) {
            return bjVar.dto;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bjVar.aKJ();
        originalThreadInfo.forumId = bjVar.getFid();
        originalThreadInfo.threadId = bjVar.getTid();
        originalThreadInfo.title = bjVar.getTitle();
        originalThreadInfo.threadType = bjVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bjVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.dpb = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.dpa = arrayList2;
        originalThreadInfo.videoInfo = bjVar.aKV();
        if (bjVar.isLinkThread() && bjVar.aMf() != null) {
            ag aMf = bjVar.aMf();
            originalThreadInfo.title = aMf.aJd();
            abstractData.text = aMf.aJe();
            mediaData.setPic(aMf.aJf());
        } else if (bjVar.aLI() && bjVar.aKk() != null) {
            mediaData.setPic(bjVar.aKk().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.v.getCount(bjVar.aKO()) > 0) {
            originalThreadInfo.dpa = bjVar.aKO();
        } else if (bjVar.aKV() != null && !StringUtils.isNull(bjVar.aKV().thumbnail_url)) {
            mediaData.setPic(bjVar.aKV().thumbnail_url);
        }
        originalThreadInfo.dpc = bjVar.aKX();
        originalThreadInfo.aJp();
        originalThreadInfo.oriUgcInfo = bjVar.getBaijiahaoData();
        return originalThreadInfo;
    }

    public bj aJm() {
        bj bjVar = new bj();
        bjVar.setTitle(this.title);
        if (this.dpa != null) {
            bjVar.z(new ArrayList<>(this.dpa));
        }
        bjVar.tT(this.forumName);
        bjVar.setTid(this.threadId);
        bjVar.a(this.dpc);
        bjVar.setFid(this.forumId);
        bjVar.setThreadType(this.threadType);
        bjVar.isShareThread = true;
        bjVar.setBaijiahaoData(this.oriUgcInfo);
        bjVar.a(this.videoInfo);
        bjVar.ub(this.showPicUrl);
        bjVar.dto = this;
        return bjVar;
    }

    private void aJn() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean aJo() {
        return this.dpg;
    }

    public void aJp() {
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
        if (com.baidu.tbadk.core.util.v.getItem(this.dpa, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.dpa, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.dpa, 0)).getPicUrl();
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
        } else if (com.baidu.tbadk.core.util.v.getItem(this.dpb, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpb, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpb, 0)).text;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData aJq() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aJr() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.xc(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean aJr() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String aJs() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.v.getItem(this.dpb, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpb, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpb, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean aJt() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean aJu() {
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
