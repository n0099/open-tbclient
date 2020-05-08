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
    public boolean doi = false;
    public ArrayList<MediaData> dpe;
    public List<AbstractData> dpf;
    public AlaInfoData dpg;
    public boolean dph;
    public ArrayList<VoiceData.VoiceModel> dpi;
    public SpannableString dpj;
    public boolean dpk;
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
            aJl();
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
            this.dpe = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dpe.add(mediaData);
                }
            }
        } else {
            this.dpe = null;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(originThreadInfo._abstract)) {
            this.dpf = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.dpf.add(abstractData);
                }
            }
        } else {
            this.dpf = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.dpg = new AlaInfoData();
            this.dpg.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.dpg = null;
        }
        this.doi = originThreadInfo.is_deleted.intValue() == 1;
        this.dph = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.dpk = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.dpi = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.dpi.add(voiceModel);
            }
        }
        aJn();
        aJj();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            aJl();
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
                this.dpg = new AlaInfoData();
                this.dpg.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.dpe = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.dpe.add(mediaData);
                }
            } else {
                this.dpe = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.dpf = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.dpf.add(abstractData);
                }
            } else {
                this.dpf = null;
            }
            this.doi = jSONObject.optInt("is_deleted") == 1;
            this.dph = jSONObject.optInt("is_ugc") == 1;
            this.dpk = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = bs.cv(jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.dpi = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.dpi.add(voiceModel);
                }
            }
            aJj();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                aJn();
            }
        }
    }

    private void aJj() {
        this.dpj = new SpannableString(com.baidu.tbadk.widget.richText.e.aY(this.content));
    }

    public static OriginalThreadInfo r(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        if (bjVar.dtt != null) {
            return bjVar.dtt;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bjVar.aKH();
        originalThreadInfo.forumId = bjVar.getFid();
        originalThreadInfo.threadId = bjVar.getTid();
        originalThreadInfo.title = bjVar.getTitle();
        originalThreadInfo.threadType = bjVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bjVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.dpf = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.dpe = arrayList2;
        originalThreadInfo.videoInfo = bjVar.aKT();
        if (bjVar.isLinkThread() && bjVar.aMd() != null) {
            ag aMd = bjVar.aMd();
            originalThreadInfo.title = aMd.aJb();
            abstractData.text = aMd.aJc();
            mediaData.setPic(aMd.aJd());
        } else if (bjVar.aLG() && bjVar.aKi() != null) {
            mediaData.setPic(bjVar.aKi().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.v.getCount(bjVar.aKM()) > 0) {
            originalThreadInfo.dpe = bjVar.aKM();
        } else if (bjVar.aKT() != null && !StringUtils.isNull(bjVar.aKT().thumbnail_url)) {
            mediaData.setPic(bjVar.aKT().thumbnail_url);
        }
        originalThreadInfo.dpg = bjVar.aKV();
        originalThreadInfo.aJn();
        originalThreadInfo.oriUgcInfo = bjVar.getBaijiahaoData();
        return originalThreadInfo;
    }

    public bj aJk() {
        bj bjVar = new bj();
        bjVar.setTitle(this.title);
        if (this.dpe != null) {
            bjVar.z(new ArrayList<>(this.dpe));
        }
        bjVar.tW(this.forumName);
        bjVar.setTid(this.threadId);
        bjVar.a(this.dpg);
        bjVar.setFid(this.forumId);
        bjVar.setThreadType(this.threadType);
        bjVar.isShareThread = true;
        bjVar.setBaijiahaoData(this.oriUgcInfo);
        bjVar.a(this.videoInfo);
        bjVar.ue(this.showPicUrl);
        bjVar.dtt = this;
        return bjVar;
    }

    private void aJl() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean aJm() {
        return this.dpk;
    }

    public void aJn() {
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
        if (com.baidu.tbadk.core.util.v.getItem(this.dpe, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.dpe, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.v.getItem(this.dpe, 0)).getPicUrl();
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
        } else if (com.baidu.tbadk.core.util.v.getItem(this.dpf, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpf, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpf, 0)).text;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData aJo() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aJp() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.xf(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean aJp() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String aJq() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.v.getItem(this.dpf, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpf, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.v.getItem(this.dpf, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean aJr() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean aJs() {
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
