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
    public boolean eLl = false;
    public ArrayList<MediaData> eMh;
    public List<AbstractData> eMi;
    public AlaInfoData eMj;
    public boolean eMk;
    public ArrayList<VoiceData.VoiceModel> eMl;
    public SpannableString eMm;
    public boolean eMn;
    public List<HeadItem> eMo;
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
            blY();
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
            this.eMh = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.eMh.add(mediaData);
                }
            }
        } else {
            this.eMh = null;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(originThreadInfo._abstract)) {
            this.eMi = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.eMi.add(abstractData);
                }
            }
        } else {
            this.eMi = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.eMj = new AlaInfoData();
            this.eMj.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.eMj = null;
        }
        this.eLl = originThreadInfo.is_deleted.intValue() == 1;
        this.eMk = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.eMn = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.eMl = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.eMl.add(voiceModel);
            }
        }
        if (originThreadInfo.item != null && originThreadInfo.item.item_id.longValue() != 0) {
            this.item = originThreadInfo.item;
        }
        if (this.item != null) {
            this.itemData = new ItemData();
            this.itemData.parseProto(this.item);
        }
        this.eMo = originThreadInfo.item_star;
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.eMo)) {
            this.itemStarData = new ItemStarData();
            this.itemStarData.parseProto(this.eMo);
        }
        if (originThreadInfo.poll_info != null) {
            this.pollData = new PollData();
            this.pollData.parserProtobuf(originThreadInfo.poll_info);
        }
        bma();
        blW();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            blY();
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
                this.eMj = new AlaInfoData();
                this.eMj.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.eMh = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.eMh.add(mediaData);
                }
            } else {
                this.eMh = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.eMi = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.eMi.add(abstractData);
                }
            } else {
                this.eMi = null;
            }
            this.eLl = jSONObject.optInt("is_deleted") == 1;
            this.eMk = jSONObject.optInt("is_ugc") == 1;
            this.eMn = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = ci.dr(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.eMl = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.eMl.add(voiceModel);
                }
            }
            blW();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                bma();
            }
        }
    }

    private void blW() {
        this.eMm = new SpannableString(com.baidu.tbadk.widget.richText.e.a(this.content, this.eMo, true));
    }

    public static OriginalThreadInfo t(bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        if (bzVar.eQQ != null) {
            return bzVar.eQQ;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bzVar.bnB();
        originalThreadInfo.forumId = bzVar.getFid();
        originalThreadInfo.threadId = bzVar.getTid();
        originalThreadInfo.title = bzVar.getTitle();
        originalThreadInfo.threadType = bzVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bzVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.eMi = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.eMh = arrayList2;
        originalThreadInfo.videoInfo = bzVar.bnO();
        if (bzVar.isLinkThread() && bzVar.bpe() != null) {
            ao bpe = bzVar.bpe();
            originalThreadInfo.title = bpe.blN();
            abstractData.text = bpe.blO();
            mediaData.setPic(bpe.blP());
        } else if (bzVar.boG() && bzVar.bnd() != null) {
            mediaData.setPic(bzVar.bnd().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.x.getCount(bzVar.bnG()) > 0) {
            originalThreadInfo.eMh = bzVar.bnG();
        } else if (bzVar.bnO() != null && !StringUtils.isNull(bzVar.bnO().thumbnail_url)) {
            mediaData.setPic(bzVar.bnO().thumbnail_url);
        }
        originalThreadInfo.eMj = bzVar.bnQ();
        originalThreadInfo.bma();
        originalThreadInfo.itemData = bzVar.itemData;
        originalThreadInfo.itemStarData = bzVar.itemStarData;
        originalThreadInfo.oriUgcInfo = bzVar.getBaijiahaoData();
        originalThreadInfo.pollData = bzVar.bpG();
        return originalThreadInfo;
    }

    public bz blX() {
        bz bzVar = new bz();
        bzVar.setTitle(this.title);
        if (this.eMh != null) {
            bzVar.B(new ArrayList<>(this.eMh));
        }
        bzVar.zR(this.forumName);
        bzVar.setTid(this.threadId);
        bzVar.a(this.eMj);
        bzVar.setFid(this.forumId);
        bzVar.setThreadType(this.threadType);
        bzVar.isShareThread = true;
        bzVar.setBaijiahaoData(this.oriUgcInfo);
        bzVar.a(this.videoInfo);
        bzVar.zZ(this.showPicUrl);
        bzVar.eQQ = this;
        return bzVar;
    }

    private void blY() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean blZ() {
        return this.eMn;
    }

    public void bma() {
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
        if (com.baidu.tbadk.core.util.x.getItem(this.eMh, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.x.getItem(this.eMh, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.x.getItem(this.eMh, 0)).getPicUrl();
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
        if (com.baidu.tbadk.core.util.x.getItem(this.eMi, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eMi, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eMi, 0)).text;
        } else if (!StringUtils.isNull(this.title)) {
            this.showText = this.title;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData bmb() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bmc() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Dm(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean bmc() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String bmd() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.x.getItem(this.eMi, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eMi, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.x.getItem(this.eMi, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean bme() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean bmf() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 2;
    }

    public boolean bmg() {
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
