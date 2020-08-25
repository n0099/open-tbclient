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
/* loaded from: classes2.dex */
public class OriginalThreadInfo {
    public Agree agree;
    public User author;
    public List<PbContent> content;
    public boolean dYh = false;
    public ArrayList<MediaData> dZc;
    public List<AbstractData> dZd;
    public AlaInfoData dZe;
    public boolean dZf;
    public ArrayList<VoiceData.VoiceModel> dZg;
    public SpannableString dZh;
    public boolean dZi;
    public List<HeadItem> dZj;
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
            bdg();
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(originThreadInfo.media)) {
            this.dZc = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.dZc.add(mediaData);
                }
            }
        } else {
            this.dZc = null;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(originThreadInfo._abstract)) {
            this.dZd = new ArrayList();
            for (Abstract r0 : originThreadInfo._abstract) {
                if (r0 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r0);
                    this.dZd.add(abstractData);
                }
            }
        } else {
            this.dZd = null;
        }
        if (originThreadInfo.ala_info != null) {
            this.dZe = new AlaInfoData();
            this.dZe.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.dZe = null;
        }
        this.dYh = originThreadInfo.is_deleted.intValue() == 1;
        this.dZf = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            this.oriUgcInfo = new BaijiahaoData();
            this.oriUgcInfo.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.videoInfo = originThreadInfo.video_info;
        this.dZi = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.dZg = new ArrayList<>();
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                this.dZg.add(voiceModel);
            }
        }
        if (originThreadInfo.item != null && originThreadInfo.item.item_id.longValue() != 0) {
            this.item = originThreadInfo.item;
        }
        if (this.item != null) {
            this.itemData = new ItemData();
            this.itemData.parseProto(this.item);
        }
        this.dZj = originThreadInfo.item_star;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.dZj)) {
            this.itemStarData = new ItemStarData();
            this.itemStarData.parseProto(this.dZj);
        }
        if (originThreadInfo.poll_info != null) {
            this.pollData = new PollData();
            this.pollData.parserProtobuf(originThreadInfo.poll_info);
        }
        bdi();
        bde();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            bdg();
            return;
        }
        try {
            this.forumName = jSONObject.optString("fname");
            this.forumId = jSONObject.optLong("fid", 0L);
            this.threadId = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.threadType = jSONObject.optInt("thread_type");
            this.content = aw.Q(jSONObject.optJSONArray("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                this.dZe = new AlaInfoData();
                this.dZe.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("media");
            if (optJSONArray != null) {
                this.dZc = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.dZc.add(mediaData);
                }
            } else {
                this.dZc = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.dZd = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.dZd.add(abstractData);
                }
            } else {
                this.dZd = null;
            }
            this.dYh = jSONObject.optInt("is_deleted") == 1;
            this.dZf = jSONObject.optInt("is_ugc") == 1;
            this.dZi = jSONObject.optInt("is_new_style") == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                this.oriUgcInfo = new BaijiahaoData();
                this.oriUgcInfo.parseJson(optJSONObject2);
            }
            this.videoInfo = cf.cU(jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.dZg = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                    this.dZg.add(voiceModel);
                }
            }
            bde();
        } catch (Throwable th) {
            try {
                BdLog.e(th.getMessage());
            } finally {
                bdi();
            }
        }
    }

    private void bde() {
        this.dZh = new SpannableString(com.baidu.tbadk.widget.richText.e.l(this.content, this.dZj));
    }

    public static OriginalThreadInfo s(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        if (bwVar.edE != null) {
            return bwVar.edE;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.forumName = bwVar.beI();
        originalThreadInfo.forumId = bwVar.getFid();
        originalThreadInfo.threadId = bwVar.getTid();
        originalThreadInfo.title = bwVar.getTitle();
        originalThreadInfo.threadType = bwVar.getThreadType();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = bwVar.getAbstract();
        arrayList.add(abstractData);
        originalThreadInfo.dZd = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo.dZc = arrayList2;
        originalThreadInfo.videoInfo = bwVar.beW();
        if (bwVar.isLinkThread() && bwVar.bgi() != null) {
            am bgi = bwVar.bgi();
            originalThreadInfo.title = bgi.bcW();
            abstractData.text = bgi.bcX();
            mediaData.setPic(bgi.bcY());
        } else if (bwVar.bfL() && bwVar.bek() != null) {
            mediaData.setPic(bwVar.bek().getThreadImgUrl());
        } else if (com.baidu.tbadk.core.util.y.getCount(bwVar.beN()) > 0) {
            originalThreadInfo.dZc = bwVar.beN();
        } else if (bwVar.beW() != null && !StringUtils.isNull(bwVar.beW().thumbnail_url)) {
            mediaData.setPic(bwVar.beW().thumbnail_url);
        }
        originalThreadInfo.dZe = bwVar.beY();
        originalThreadInfo.bdi();
        originalThreadInfo.itemData = bwVar.itemData;
        originalThreadInfo.itemStarData = bwVar.itemStarData;
        originalThreadInfo.oriUgcInfo = bwVar.getBaijiahaoData();
        originalThreadInfo.pollData = bwVar.bgJ();
        return originalThreadInfo;
    }

    public bw bdf() {
        bw bwVar = new bw();
        bwVar.setTitle(this.title);
        if (this.dZc != null) {
            bwVar.G(new ArrayList<>(this.dZc));
        }
        bwVar.zn(this.forumName);
        bwVar.setTid(this.threadId);
        bwVar.a(this.dZe);
        bwVar.setFid(this.forumId);
        bwVar.setThreadType(this.threadType);
        bwVar.isShareThread = true;
        bwVar.setBaijiahaoData(this.oriUgcInfo);
        bwVar.a(this.videoInfo);
        bwVar.zv(this.showPicUrl);
        bwVar.edE = this;
        return bwVar;
    }

    private void bdg() {
        this.showType = 0;
        this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.showPicUrl = null;
    }

    public boolean bdh() {
        return this.dZi;
    }

    public void bdi() {
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
        if (com.baidu.tbadk.core.util.y.getItem(this.dZc, 0) != null) {
            this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.y.getItem(this.dZc, 0)).small_pic_url;
            if (StringUtils.isNull(this.showPicUrl)) {
                this.showPicUrl = ((MediaData) com.baidu.tbadk.core.util.y.getItem(this.dZc, 0)).getPicUrl();
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
        if (com.baidu.tbadk.core.util.y.getItem(this.dZd, 0) != null && !StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.y.getItem(this.dZd, 0)).text)) {
            this.showText = ((AbstractData) com.baidu.tbadk.core.util.y.getItem(this.dZd, 0)).text;
        } else if (!StringUtils.isNull(this.title)) {
            this.showText = this.title;
        } else {
            this.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    public ActivityItemData bdj() {
        if (this.content != null && this.content.size() > 0) {
            int size = this.content.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.content.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bdk() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.CB(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public boolean bdk() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public String bdl() {
        String str;
        if (!StringUtils.isNull(this.title)) {
            str = this.title;
        } else if (com.baidu.tbadk.core.util.y.getItem(this.dZd, 0) == null || StringUtils.isNull(((AbstractData) com.baidu.tbadk.core.util.y.getItem(this.dZd, 0)).text)) {
            str = null;
        } else {
            str = ((AbstractData) com.baidu.tbadk.core.util.y.getItem(this.dZd, 0)).text;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        return str;
    }

    public boolean bdm() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 1;
    }

    public boolean bdn() {
        return this.oriUgcInfo != null && this.oriUgcInfo.oriUgcType == 2;
    }

    public boolean bdo() {
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

    /* loaded from: classes2.dex */
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

        public static ShareInfo generateShareInfo(bw bwVar) {
            return generateShareInfo(OriginalThreadInfo.s(bwVar));
        }
    }
}
