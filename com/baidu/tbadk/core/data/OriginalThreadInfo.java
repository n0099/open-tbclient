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
import d.b.h0.b1.m.e;
import d.b.h0.p0.b;
import d.b.h0.r.q.a1;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.j2;
import d.b.h0.r.q.p0;
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
    public int f12872a;

    /* renamed from: b  reason: collision with root package name */
    public String f12873b;

    /* renamed from: c  reason: collision with root package name */
    public String f12874c;

    /* renamed from: d  reason: collision with root package name */
    public String f12875d;

    /* renamed from: e  reason: collision with root package name */
    public long f12876e;

    /* renamed from: f  reason: collision with root package name */
    public String f12877f;

    /* renamed from: g  reason: collision with root package name */
    public String f12878g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f12879h;
    public List<AbstractData> i;
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
        OriginalThreadInfo originalThreadInfo = a2Var.r1;
        if (originalThreadInfo != null) {
            return originalThreadInfo;
        }
        OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
        originalThreadInfo2.f12875d = a2Var.i0();
        originalThreadInfo2.f12876e = a2Var.c0();
        originalThreadInfo2.f12877f = a2Var.w1();
        originalThreadInfo2.f12878g = a2Var.x1();
        originalThreadInfo2.k = a2Var.s1();
        ArrayList arrayList = new ArrayList();
        AbstractData abstractData = new AbstractData();
        abstractData.text = a2Var.C();
        arrayList.add(abstractData);
        originalThreadInfo2.i = arrayList;
        ArrayList<MediaData> arrayList2 = new ArrayList<>();
        MediaData mediaData = new MediaData();
        arrayList2.add(mediaData);
        originalThreadInfo2.f12879h = arrayList2;
        originalThreadInfo2.r = a2Var.u1();
        if (a2Var.f2() && a2Var.H0() != null) {
            p0 H0 = a2Var.H0();
            originalThreadInfo2.f12878g = H0.d();
            abstractData.text = H0.a();
            mediaData.setPic(H0.b());
        } else if (a2Var.e2() && a2Var.o1() != null) {
            mediaData.setPic(a2Var.o1().i());
        } else if (ListUtils.getCount(a2Var.K0()) > 0) {
            originalThreadInfo2.f12879h = a2Var.K0();
        } else if (a2Var.u1() != null && !StringUtils.isNull(a2Var.u1().thumbnail_url)) {
            mediaData.setPic(a2Var.u1().thumbnail_url);
        }
        originalThreadInfo2.j = a2Var.q1();
        originalThreadInfo2.n();
        originalThreadInfo2.A = a2Var.r2;
        originalThreadInfo2.C = a2Var.t2;
        originalThreadInfo2.p = a2Var.V();
        originalThreadInfo2.D = a2Var.O0();
        return originalThreadInfo2;
    }

    public a2 a() {
        a2 a2Var = new a2();
        a2Var.n4(this.f12878g);
        if (this.f12879h != null) {
            a2Var.V3(new ArrayList<>(this.f12879h));
        }
        a2Var.y3(this.f12875d);
        a2Var.m4(this.f12877f);
        a2Var.j4(this.j);
        a2Var.u3(this.f12876e);
        a2Var.l4(this.k);
        a2Var.s1 = true;
        a2Var.r3(this.p);
        a2Var.r4(this.r);
        a2Var.p3(this.f12874c);
        a2Var.r1 = this;
        return a2Var;
    }

    public ActivityItemData b() {
        String str;
        List<PbContent> list = this.s;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = this.s.size();
        for (int i = 0; i < size; i++) {
            PbContent pbContent = this.s.get(i);
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
        if (!StringUtils.isNull(this.f12878g)) {
            str = this.f12878g;
        } else {
            str = (ListUtils.getItem(this.i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.i, 0)).text;
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
        int i = baijiahaoData.oriUgcType;
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public boolean h() {
        int i = this.k;
        return i == 40 || i == 50;
    }

    public void j(OriginThreadInfo originThreadInfo) {
        if (originThreadInfo == null) {
            m();
            return;
        }
        this.f12875d = originThreadInfo.fname;
        this.f12876e = originThreadInfo.fid.longValue();
        this.f12877f = originThreadInfo.tid;
        this.f12878g = originThreadInfo.title;
        this.k = originThreadInfo.thread_type.intValue();
        this.s = originThreadInfo.content;
        this.v = originThreadInfo.author;
        this.w = originThreadInfo.agree;
        this.x = originThreadInfo.reply_num;
        this.y = originThreadInfo.shared_num;
        if (!ListUtils.isEmpty(originThreadInfo.media)) {
            this.f12879h = new ArrayList<>();
            for (Media media : originThreadInfo.media) {
                if (media != null) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(media);
                    this.f12879h.add(mediaData);
                }
            }
        } else {
            this.f12879h = null;
        }
        if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
            this.i = new ArrayList();
            for (Abstract r2 : originThreadInfo._abstract) {
                if (r2 != null) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parser(r2);
                    this.i.add(abstractData);
                }
            }
        } else {
            this.i = null;
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
            for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
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
            this.f12875d = jSONObject.optString("fname");
            this.f12876e = jSONObject.optLong("fid", 0L);
            this.f12877f = jSONObject.optString("tid");
            this.f12878g = jSONObject.optString("title");
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
                this.f12879h = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray.getJSONObject(i));
                    this.f12879h.add(mediaData);
                }
            } else {
                this.f12879h = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                this.i = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    AbstractData abstractData = new AbstractData();
                    abstractData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.i.add(abstractData);
                }
            } else {
                this.i = null;
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
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    voiceData$VoiceModel.parseJson(optJSONArray3.optJSONObject(i3));
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
        this.f12872a = 0;
        this.f12873b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
        this.f12874c = null;
    }

    public void n() {
        VideoInfo videoInfo;
        int i = this.k;
        if (i == 40) {
            this.f12872a = 3;
        } else if (i == 54) {
            this.f12872a = 2;
        } else if (i != 60 && i != 49 && i != 50) {
            this.f12872a = 0;
        } else {
            this.f12872a = 4;
        }
        if (ListUtils.getItem(this.f12879h, 0) != null) {
            String str = ((MediaData) ListUtils.getItem(this.f12879h, 0)).small_pic_url;
            this.f12874c = str;
            if (StringUtils.isNull(str)) {
                this.f12874c = ((MediaData) ListUtils.getItem(this.f12879h, 0)).getPicUrl();
            }
        }
        if (StringUtils.isNull(this.f12874c) && (videoInfo = this.r) != null) {
            this.f12874c = videoInfo.thumbnail_url;
        }
        if (this.f12872a == 0) {
            if (StringUtils.isNull(this.f12874c)) {
                this.f12872a = 0;
            } else {
                this.f12872a = 1;
            }
        }
        if (ListUtils.getItem(this.i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.i, 0)).text)) {
            this.f12873b = ((AbstractData) ListUtils.getItem(this.i, 0)).text;
        } else if (!StringUtils.isNull(this.f12878g)) {
            this.f12873b = this.f12878g;
        } else {
            this.f12873b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
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
            shareInfo.threadId = originalThreadInfo.f12877f;
            shareInfo.showType = originalThreadInfo.f12872a;
            shareInfo.showText = originalThreadInfo.f12873b;
            shareInfo.showPicUrl = originalThreadInfo.f12874c;
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
