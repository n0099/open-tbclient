package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
import tbclient.HeadItem;
import tbclient.Item;
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
    public boolean ePW = false;
    public ArrayList<MediaData> eQS;
    public List<AbstractData> eQT;
    public AlaInfoData eQU;
    public boolean eQV;
    public ArrayList<VoiceData.VoiceModel> eQW;
    public SpannableString eQX;
    public boolean eQY;
    public List<HeadItem> eQZ;
    public long forumId;
    public String forumName;
    public Item item;
    public ItemData itemData;
    public ItemStarData itemStarData;
    public BaijiahaoData oriUgcInfo;
    public PollData pollData;
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
            bpR();
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(originThreadInfo.media)) {
            this.eQS = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.eQS.add(mediaData);
                }
            }
        } else {
            this.eQS = null;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(originThreadInfo._abstract)) {
            this.eQT = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.eQT.add(abstractData);
                }
            }
        } else {
            this.eQT = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.eQU = new AlaInfoData();
            this.eQU.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.eQU = null;
        }
        this.ePW = originThreadInfo.is_deleted.intValue() == 1;
        this.eQV = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.eQY = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.eQW = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.eQW.add(voiceModel);
            }
        }
        if (originThreadInfo.item != null && originThreadInfo.item.item_id.longValue() != 0) {
            this.item = originThreadInfo.item;
        }
        if (this.item != null) {
            this.itemData = new ItemData();
            this.itemData.parseProto(this.item);
        }
        this.eQZ = originThreadInfo.item_star;
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.eQZ)) {
            this.itemStarData = new ItemStarData();
            this.itemStarData.parseProto(this.eQZ);
        }
        if (originThreadInfo.poll_info != null) {
            this.pollData = new PollData();
            this.pollData.parserProtobuf(originThreadInfo.poll_info);
        }
        bpT();
        bpP();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            bpR();
            return;
        }
        try {
            this.forumName = jSONObject.optString("fname");
            this.forumId = jSONObject.optLong("fid", 0L);
            this.threadId = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.threadType = jSONObject.optInt("thread_type");
            this.content = ay.R(jSONObject.optJSONArray("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.eQU = new AlaInfoData();
                this.eQU.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.eQS = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.eQS.add(mediaData);
                }
            } else {
                this.eQS = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.eQT = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.eQT.add(abstractData);
                }
            } else {
                this.eQT = null;
            }
            this.ePW = jSONObject.optInt("is_deleted") == 1;
            this.eQV = jSONObject.optInt("is_ugc") == 1;
            this.eQY = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = ci.dr(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.eQW = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.eQW.add(voiceModel);
                }
            }
            bpP();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                bpT();
            }
        }
    }

    private void bpP() {
        this.eQX = new SpannableString(com.baidu.tbadk.widget.richText.e.a(this.content, this.eQZ, true));
    }

    public static OriginalThreadInfo t(bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        if (bzVar.eVB != null) {
            return bzVar.eVB;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bzVar.bru();
        originalThreadInfo.forumId = bzVar.getFid();
        originalThreadInfo.threadId = bzVar.getTid();
        originalThreadInfo.title = bzVar.getTitle();
        originalThreadInfo.threadType = bzVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bzVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.eQT = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.eQS = arrayList2;
        originalThreadInfo.videoInfo = bzVar.brH();
        if (bzVar.isLinkThread() && bzVar.bsX() != null) {
            ao bsX = bzVar.bsX();
            originalThreadInfo.title = bsX.bpG();
            abstractData.text = bsX.bpH();
            mediaData.setPic(bsX.bpI());
        } else if (bzVar.bsz() && bzVar.bqW() != null) {
            mediaData.setPic(bzVar.bqW().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.x.getCount(bzVar.brz()) > 0) {
            originalThreadInfo.eQS = bzVar.brz();
        } else if (bzVar.brH() != null && !StringUtils.isNull(bzVar.brH().thumbnail_url)) {
            mediaData.setPic(bzVar.brH().thumbnail_url);
        }
        originalThreadInfo.eQU = bzVar.brJ();
        originalThreadInfo.bpT();
        originalThreadInfo.itemData = bzVar.itemData;
        originalThreadInfo.itemStarData = bzVar.itemStarData;
        originalThreadInfo.oriUgcInfo = bzVar.getBaijiahaoData();
        originalThreadInfo.pollData = bzVar.btz();
        return originalThreadInfo;
    }

    public bz bpQ() {
        bz bzVar = new bz();
        bzVar.setTitle(this.title);
        if (this.eQS != null) {
            bzVar.G(new ArrayList<>(this.eQS));
        }
        bzVar.Bd(this.forumName);
        bzVar.setTid(this.threadId);
        bzVar.a(this.eQU);
        bzVar.setFid(this.forumId);
        bzVar.setThreadType(this.threadType);
        bzVar.isShareThread = true;
        bzVar.setBaijiahaoData(this.oriUgcInfo);
        bzVar.a(this.videoInfo);
        bzVar.Bl(this.showPicUrl);
        bzVar.eVB = this;
        return bzVar;
    }

    private void bpR() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean bpS() {
        return this.eQY;
    }

    public void bpT() {
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
        if (com.baidu.tbadk.core.util.x.getItem(this.eQS, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.x.getItem(this.eQS, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.x.getItem(this.eQS, 0)).getPicUrl();
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
        if (com.baidu.tbadk.core.util.x.getItem(this.eQT, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eQT, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eQT, 0)).text;
        } else if (!StringUtils.isNull(this.title)) {
            this.showText = this.title;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData bpU() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bpV() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Ey(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean bpV() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String bpW() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.x.getItem(this.eQT, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eQT, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eQT, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean bpX() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean bpY() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 2;
    }

    public boolean bpZ() {
        if (this.oriUgcInfo == null) {
            return false;
        }
        switch (this.oriUgcInfo.oriUgcType) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    /* loaded from: classes.dex */
    public static class ShareInfo extends OrmObject implements Serializable {
        public ItemData itemData;
        public ItemStarData itemStarData;
        public BaijiahaoData oriUgcInfo;
        public PollData pollData;
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
            shareInfo.itemData = originalThreadInfo.itemData;
            shareInfo.itemStarData = originalThreadInfo.itemStarData;
            shareInfo.pollData = originalThreadInfo.pollData;
            return shareInfo;
        }

        public static ShareInfo generateShareInfo(bz bzVar) {
            return generateShareInfo(OriginalThreadInfo.t(bzVar));
        }
    }
}
