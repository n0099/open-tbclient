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
    public boolean dOO = false;
    public ArrayList<MediaData> dPJ;
    public List<AbstractData> dPK;
    public AlaInfoData dPL;
    public boolean dPM;
    public ArrayList<VoiceData.VoiceModel> dPN;
    public SpannableString dPO;
    public boolean dPP;
    public List<HeadItem> dPQ;
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
            aUN();
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
            this.dPJ = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dPJ.add(mediaData);
                }
            }
        } else {
            this.dPJ = null;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(originThreadInfo._abstract)) {
            this.dPK = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.dPK.add(abstractData);
                }
            }
        } else {
            this.dPK = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.dPL = new AlaInfoData();
            this.dPL.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.dPL = null;
        }
        this.dOO = originThreadInfo.is_deleted.intValue() == 1;
        this.dPM = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.dPP = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.dPN = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.dPN.add(voiceModel);
            }
        }
        if (originThreadInfo.item != null && originThreadInfo.item.item_id.longValue() != 0) {
            this.item = originThreadInfo.item;
        }
        if (this.item != null) {
            this.itemData = new ItemData();
            this.itemData.parseProto(this.item);
        }
        this.dPQ = originThreadInfo.item_star;
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.dPQ)) {
            this.itemStarData = new ItemStarData();
            this.itemStarData.parseProto(this.dPQ);
        }
        if (originThreadInfo.poll_info != null) {
            this.pollData = new PollData();
            this.pollData.parserProtobuf(originThreadInfo.poll_info);
        }
        aUP();
        aUL();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            aUN();
            return;
        }
        try {
            this.forumName = jSONObject.optString("fname");
            this.forumId = jSONObject.optLong("fid", 0L);
            this.threadId = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.threadType = jSONObject.optInt("thread_type");
            this.content = av.O(jSONObject.optJSONArray("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.dPL = new AlaInfoData();
                this.dPL.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.dPJ = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.dPJ.add(mediaData);
                }
            } else {
                this.dPJ = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.dPK = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.dPK.add(abstractData);
                }
            } else {
                this.dPK = null;
            }
            this.dOO = jSONObject.optInt("is_deleted") == 1;
            this.dPM = jSONObject.optInt("is_ugc") == 1;
            this.dPP = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = ce.cO(jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.dPN = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.dPN.add(voiceModel);
                }
            }
            aUL();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                aUP();
            }
        }
    }

    private void aUL() {
        this.dPO = new SpannableString(com.baidu.tbadk.widget.richText.e.i(this.content, this.dPQ));
    }

    public static OriginalThreadInfo s(bv bvVar) {
        if (bvVar == null) {
            return null;
        }
        if (bvVar.dUi != null) {
            return bvVar.dUi;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bvVar.aWp();
        originalThreadInfo.forumId = bvVar.getFid();
        originalThreadInfo.threadId = bvVar.getTid();
        originalThreadInfo.title = bvVar.getTitle();
        originalThreadInfo.threadType = bvVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bvVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.dPK = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.dPJ = arrayList2;
        originalThreadInfo.videoInfo = bvVar.aWD();
        if (bvVar.isLinkThread() && bvVar.aXP() != null) {
            al aXP = bvVar.aXP();
            originalThreadInfo.title = aXP.aUD();
            abstractData.text = aXP.aUE();
            mediaData.setPic(aXP.aUF());
        } else if (bvVar.aXs() && bvVar.aVR() != null) {
            mediaData.setPic(bvVar.aVR().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.x.getCount(bvVar.aWu()) > 0) {
            originalThreadInfo.dPJ = bvVar.aWu();
        } else if (bvVar.aWD() != null && !StringUtils.isNull(bvVar.aWD().thumbnail_url)) {
            mediaData.setPic(bvVar.aWD().thumbnail_url);
        }
        originalThreadInfo.dPL = bvVar.aWF();
        originalThreadInfo.aUP();
        originalThreadInfo.itemData = bvVar.itemData;
        originalThreadInfo.itemStarData = bvVar.itemStarData;
        originalThreadInfo.oriUgcInfo = bvVar.getBaijiahaoData();
        originalThreadInfo.pollData = bvVar.aYq();
        return originalThreadInfo;
    }

    public bv aUM() {
        bv bvVar = new bv();
        bvVar.setTitle(this.title);
        if (this.dPJ != null) {
            bvVar.A(new ArrayList<>(this.dPJ));
        }
        bvVar.wZ(this.forumName);
        bvVar.setTid(this.threadId);
        bvVar.a(this.dPL);
        bvVar.setFid(this.forumId);
        bvVar.setThreadType(this.threadType);
        bvVar.isShareThread = true;
        bvVar.setBaijiahaoData(this.oriUgcInfo);
        bvVar.a(this.videoInfo);
        bvVar.xh(this.showPicUrl);
        bvVar.dUi = this;
        return bvVar;
    }

    private void aUN() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean aUO() {
        return this.dPP;
    }

    public void aUP() {
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
        if (com.baidu.tbadk.core.util.x.getItem(this.dPJ, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.x.getItem(this.dPJ, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.x.getItem(this.dPJ, 0)).getPicUrl();
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
        if (com.baidu.tbadk.core.util.x.getItem(this.dPK, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.dPK, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.dPK, 0)).text;
        } else if (!StringUtils.isNull(this.title)) {
            this.showText = this.title;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData aUQ() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aUR() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Al(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean aUR() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String aUS() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.x.getItem(this.dPK, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.dPK, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.dPK, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean aUT() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean aUU() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 2;
    }

    public boolean aUV() {
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

        public static ShareInfo generateShareInfo(bv bvVar) {
            return generateShareInfo(OriginalThreadInfo.s(bvVar));
        }
    }
}
