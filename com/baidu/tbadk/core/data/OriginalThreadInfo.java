package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.video.ActivityItemData;
import com.baidubce.services.vod.VodClient;
import d.a.m0.b1.m.e;
import d.a.m0.p0.b;
import d.a.m0.r.q.a1;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.j2;
import d.a.m0.r.q.p0;
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
/* loaded from: classes3.dex */
public class OriginalThreadInfo {
    public ItemData A;
    public List<HeadItem> B;
    public ItemStarData C;
    public PollData D;

    /* renamed from: a  reason: collision with root package name */
    public int f12095a;

    /* renamed from: b  reason: collision with root package name */
    public String f12096b;

    /* renamed from: c  reason: collision with root package name */
    public String f12097c;

    /* renamed from: d  reason: collision with root package name */
    public String f12098d;

    /* renamed from: e  reason: collision with root package name */
    public long f12099e;

    /* renamed from: f  reason: collision with root package name */
    public String f12100f;

    /* renamed from: g  reason: collision with root package name */
    public String f12101g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f12102h;

    /* renamed from: i  reason: collision with root package name */
    public List<AbstractData> f12103i;
    public AlaInfoData j;
    public int k;
    public String l;
    public boolean m = false;
    public String n;
    public boolean o;
    public BaijiahaoData p;
    public ArrayList<VoiceData$VoiceModel> q;
    public VideoInfo r;
    public List<PbContent> s;
    public SpannableString t;
    public boolean u;
    public User v;
    public Agree w;
    public Integer x;
    public Integer y;
    public Item z;

    public static OriginalThreadInfo i(a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        OriginalThreadInfo originalThreadInfo = a2Var.t1;
        if (originalThreadInfo != null) {
            return originalThreadInfo;
        }
        OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
        originalThreadInfo2.f12098d = a2Var.i0();
        originalThreadInfo2.f12099e = a2Var.c0();
        originalThreadInfo2.f12100f = a2Var.z1();
        originalThreadInfo2.f12101g = a2Var.A1();
        originalThreadInfo2.k = a2Var.v1();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = a2Var.C();
        arrayList.add(abstractData);
        originalThreadInfo2.f12103i = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo2.f12102h = arrayList2;
        originalThreadInfo2.r = a2Var.x1();
        if (a2Var.i2() && a2Var.I0() != null) {
            p0 I0 = a2Var.I0();
            originalThreadInfo2.f12101g = I0.d();
            abstractData.text = I0.a();
            mediaData.setPic(I0.b());
        } else if (a2Var.h2() && a2Var.q1() != null) {
            mediaData.setPic(a2Var.q1().i());
        } else if (ListUtils.getCount(a2Var.L0()) > 0) {
            originalThreadInfo2.f12102h = a2Var.L0();
        } else if (a2Var.x1() != null && !StringUtils.isNull(a2Var.x1().thumbnail_url)) {
            mediaData.setPic(a2Var.x1().thumbnail_url);
        }
        originalThreadInfo2.j = a2Var.s1();
        originalThreadInfo2.n();
        originalThreadInfo2.A = a2Var.u2;
        originalThreadInfo2.C = a2Var.w2;
        originalThreadInfo2.p = a2Var.V();
        originalThreadInfo2.D = a2Var.P0();
        return originalThreadInfo2;
    }

    public a2 a() {
        a2 a2Var = new a2();
        a2Var.r4(this.f12101g);
        if (this.f12102h != null) {
            a2Var.Z3(new ArrayList<>(this.f12102h));
        }
        a2Var.C3(this.f12098d);
        a2Var.q4(this.f12100f);
        a2Var.n4(this.j);
        a2Var.y3(this.f12099e);
        a2Var.p4(this.k);
        a2Var.u1 = true;
        a2Var.v3(this.p);
        a2Var.v4(this.r);
        a2Var.t3(this.f12097c);
        a2Var.t1 = this;
        return a2Var;
    }

    public ActivityItemData b() {
        String str;
        List<PbContent> list = this.s;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            PbContent pbContent = this.s.get(i2);
            if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && h() && (str = pbContent.text) != null && str.length() >= 3) {
                ActivityItemData activityItemData = new ActivityItemData();
                activityItemData.link_url = b.d(pbContent.text);
                String str2 = pbContent.text;
                activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                return activityItemData;
            }
        }
        return null;
    }

    public String c() {
        String str;
        if (!StringUtils.isNull(this.f12101g)) {
            str = this.f12101g;
        } else {
            str = (ListUtils.getItem(this.f12103i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f12103i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.f12103i, 0)).text;
        }
        return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title) : str;
    }

    public boolean d() {
        BaijiahaoData baijiahaoData = this.p;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
    }

    public boolean e() {
        BaijiahaoData baijiahaoData = this.p;
        return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
    }

    public boolean f() {
        return this.u;
    }

    public boolean g() {
        BaijiahaoData baijiahaoData = this.p;
        if (baijiahaoData == null) {
            return false;
        }
        int i2 = baijiahaoData.oriUgcType;
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
    }

    public boolean h() {
        int i2 = this.k;
        return i2 == 40 || i2 == 50;
    }

    public void j(OriginThreadInfo originThreadInfo) {
        if (originThreadInfo == null) {
            m();
            return;
        }
        this.f12098d = originThreadInfo.fname;
        this.f12099e = originThreadInfo.fid.longValue();
        this.f12100f = originThreadInfo.tid;
        this.f12101g = originThreadInfo.title;
        this.k = originThreadInfo.thread_type.intValue();
        this.s = originThreadInfo.content;
        this.v = originThreadInfo.author;
        this.w = originThreadInfo.agree;
        this.x = originThreadInfo.reply_num;
        this.y = originThreadInfo.shared_num;
        if (!ListUtils.isEmpty(originThreadInfo.media)) {
            this.f12102h = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.f12102h.add(mediaData);
                }
            }
        } else {
            this.f12102h = null;
        }
        if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
            this.f12103i = new ArrayList();
            for (Abstract r2 : originThreadInfo._abstract) {
                if (r2 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r2);
                    this.f12103i.add(abstractData);
                }
            }
        } else {
            this.f12103i = null;
        }
        if (originThreadInfo.ala_info != null) {
            AlaInfoData alaInfoData = new AlaInfoData();
            this.j = alaInfoData;
            alaInfoData.parserProtobuf(originThreadInfo.ala_info);
        } else {
            this.j = null;
        }
        this.m = originThreadInfo.is_deleted.intValue() == 1;
        this.o = originThreadInfo.is_ugc.intValue() == 1;
        if (originThreadInfo.ori_ugc_info != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            this.p = baijiahaoData;
            baijiahaoData.parseProto(originThreadInfo.ori_ugc_info);
        }
        this.r = originThreadInfo.video_info;
        this.u = originThreadInfo.is_new_style.intValue() == 1;
        if (originThreadInfo.voice_info != null) {
            this.q = new ArrayList<>();
            for (int i2 = 0; i2 < originThreadInfo.voice_info.size(); i2++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(originThreadInfo.voice_info.get(i2));
                this.q.add(voiceData$VoiceModel);
            }
        }
        Item item = originThreadInfo.item;
        if (item != null && item.item_id.longValue() != 0) {
            this.z = originThreadInfo.item;
        }
        if (this.z != null) {
            ItemData itemData = new ItemData();
            this.A = itemData;
            itemData.parseProto(this.z);
        }
        List<HeadItem> list = originThreadInfo.item_star;
        this.B = list;
        if (!ListUtils.isEmpty(list)) {
            ItemStarData itemStarData = new ItemStarData();
            this.C = itemStarData;
            itemStarData.parseProto(this.B);
        }
        if (originThreadInfo.poll_info != null) {
            PollData pollData = new PollData();
            this.D = pollData;
            pollData.parserProtobuf(originThreadInfo.poll_info);
        }
        n();
        k();
    }

    public final void k() {
        this.t = new SpannableString(e.z(this.s, this.B, true));
    }

    public void l(JSONObject jSONObject) {
        if (jSONObject == null) {
            m();
            return;
        }
        try {
            this.f12098d = jSONObject.optString("fname");
            this.f12099e = jSONObject.optLong("fid", 0L);
            this.f12100f = jSONObject.optString("tid");
            this.f12101g = jSONObject.optString("title");
            this.k = jSONObject.optInt("thread_type");
            this.s = a1.a(jSONObject.optJSONArray("content"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
            if (optJSONObject != null) {
                AlaInfoData alaInfoData = new AlaInfoData();
                this.j = alaInfoData;
                alaInfoData.parserJson(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
            if (optJSONArray != null) {
                this.f12102h = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i2));
                    this.f12102h.add(mediaData);
                }
            } else {
                this.f12102h = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.f12103i = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i3));
                    this.f12103i.add(abstractData);
                }
            } else {
                this.f12103i = null;
            }
            boolean z = true;
            this.m = jSONObject.optInt("is_deleted") == 1;
            this.o = jSONObject.optInt("is_ugc") == 1;
            if (jSONObject.optInt("is_new_style") != 1) {
                z = false;
            }
            this.u = z;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
            if (optJSONObject2 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.p = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject2);
            }
            this.r = j2.a(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.q = new ArrayList<>();
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    voiceData$VoiceModel.parseJson(optJSONArray3.optJSONObject(i4));
                    this.q.add(voiceData$VoiceModel);
                }
            }
            k();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void m() {
        this.f12095a = 0;
        this.f12096b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.f12097c = null;
    }

    public void n() {
        VideoInfo videoInfo;
        int i2 = this.k;
        if (i2 == 40) {
            this.f12095a = 3;
        } else if (i2 == 54) {
            this.f12095a = 2;
        } else if (i2 != 60 && i2 != 69 && i2 != 49 && i2 != 50) {
            this.f12095a = 0;
        } else {
            this.f12095a = 4;
        }
        if (ListUtils.getItem(this.f12102h, 0) != null) {
            String str = ((MediaData) ListUtils.getItem(this.f12102h, 0)).small_pic_url;
            this.f12097c = str;
            if (StringUtils.isNull(str)) {
                this.f12097c = ((MediaData) ListUtils.getItem(this.f12102h, 0)).getPicUrl();
            }
        }
        if (StringUtils.isNull(this.f12097c) && (videoInfo = this.r) != null) {
            this.f12097c = videoInfo.thumbnail_url;
        }
        if (this.f12095a == 0) {
            if (StringUtils.isNull(this.f12097c)) {
                this.f12095a = 0;
            } else {
                this.f12095a = 1;
            }
        }
        if (ListUtils.getItem(this.f12103i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f12103i, 0)).text)) {
            this.f12096b = ((AbstractData) ListUtils.getItem(this.f12103i, 0)).text;
        } else if (!StringUtils.isNull(this.f12101g)) {
            this.f12096b = this.f12101g;
        } else {
            this.f12096b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        }
    }

    /* loaded from: classes3.dex */
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
            shareInfo.threadId = originalThreadInfo.f12100f;
            shareInfo.showType = originalThreadInfo.f12095a;
            shareInfo.showText = originalThreadInfo.f12096b;
            shareInfo.showPicUrl = originalThreadInfo.f12097c;
            shareInfo.videoId = originalThreadInfo.l;
            shareInfo.oriUgcInfo = originalThreadInfo.p;
            shareInfo.itemData = originalThreadInfo.A;
            shareInfo.itemStarData = originalThreadInfo.C;
            shareInfo.pollData = originalThreadInfo.D;
            return shareInfo;
        }

        public static ShareInfo generateShareInfo(a2 a2Var) {
            return generateShareInfo(OriginalThreadInfo.i(a2Var));
        }
    }
}
