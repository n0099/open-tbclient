package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.f1.n.e;
import c.a.s0.f1.p.a;
import c.a.s0.s.q.c1;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.n2;
import c.a.s0.s.q.r0;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
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
/* loaded from: classes11.dex */
public class OriginalThreadInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer A;
    public Integer B;
    public Item C;
    public ItemData D;
    public List<HeadItem> E;
    public ItemStarData F;
    public PollData G;
    public boolean H;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f40156b;

    /* renamed from: c  reason: collision with root package name */
    public String f40157c;

    /* renamed from: d  reason: collision with root package name */
    public String f40158d;

    /* renamed from: e  reason: collision with root package name */
    public long f40159e;

    /* renamed from: f  reason: collision with root package name */
    public String f40160f;

    /* renamed from: g  reason: collision with root package name */
    public String f40161g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f40162h;

    /* renamed from: i  reason: collision with root package name */
    public List<AbstractData> f40163i;

    /* renamed from: j  reason: collision with root package name */
    public AlaInfoData f40164j;
    public int k;
    public String l;
    public boolean m;
    public String n;
    public boolean o;
    public BaijiahaoData p;
    public ArrayList<VoiceData$VoiceModel> q;
    public VideoInfo r;
    public List<PbContent> s;
    @NonNull
    public final List<PbContent> t;
    public SpannableString u;
    @Nullable
    public List<a> v;
    @Nullable
    public e2 w;
    public boolean x;
    public User y;
    public Agree z;

    public OriginalThreadInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.t = new ArrayList();
    }

    public static OriginalThreadInfo l(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, e2Var)) == null) {
            if (e2Var == null) {
                return null;
            }
            OriginalThreadInfo originalThreadInfo = e2Var.z1;
            if (originalThreadInfo != null) {
                return originalThreadInfo;
            }
            OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
            originalThreadInfo2.s(e2Var);
            originalThreadInfo2.f40158d = e2Var.b0();
            originalThreadInfo2.f40159e = e2Var.U();
            originalThreadInfo2.f40160f = e2Var.w1();
            originalThreadInfo2.f40161g = e2Var.getTitle();
            originalThreadInfo2.k = e2Var.s1();
            ArrayList arrayList = new ArrayList();
            AbstractData abstractData = new AbstractData();
            abstractData.text = e2Var.o();
            arrayList.add(abstractData);
            originalThreadInfo2.f40163i = arrayList;
            ArrayList<MediaData> arrayList2 = new ArrayList<>();
            MediaData mediaData = new MediaData();
            arrayList2.add(mediaData);
            originalThreadInfo2.f40162h = arrayList2;
            originalThreadInfo2.r = e2Var.u1();
            if (e2Var.i2() && e2Var.D0() != null) {
                r0 D0 = e2Var.D0();
                originalThreadInfo2.f40161g = D0.d();
                abstractData.text = D0.a();
                mediaData.setPic(D0.b());
            } else if (e2Var.h2() && e2Var.n1() != null) {
                mediaData.setPic(e2Var.n1().i());
            } else if (ListUtils.getCount(e2Var.G0()) > 0) {
                originalThreadInfo2.f40162h = e2Var.G0();
            } else if (e2Var.u1() != null && !StringUtils.isNull(e2Var.u1().thumbnail_url)) {
                mediaData.setPic(e2Var.u1().thumbnail_url);
            }
            originalThreadInfo2.f40164j = e2Var.p1();
            originalThreadInfo2.r();
            originalThreadInfo2.D = e2Var.B2;
            originalThreadInfo2.F = e2Var.D2;
            originalThreadInfo2.p = e2Var.L();
            originalThreadInfo2.G = e2Var.K0();
            return originalThreadInfo2;
        }
        return (OriginalThreadInfo) invokeL.objValue;
    }

    public e2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e2 e2Var = new e2();
            e2Var.G4(this.f40161g);
            if (this.f40162h != null) {
                e2Var.n4(new ArrayList<>(this.f40162h));
            }
            e2Var.N3(this.f40158d);
            e2Var.F4(this.f40160f);
            e2Var.C4(this.f40164j);
            e2Var.J3(this.f40159e);
            e2Var.E4(this.k);
            e2Var.A1 = true;
            e2Var.D3(this.p);
            e2Var.L4(this.r);
            e2Var.B3(this.f40157c);
            e2Var.z1 = this;
            return e2Var;
        }
        return (e2) invokeV.objValue;
    }

    @Nullable
    public SpannableString b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (SpannableString) invokeV.objValue;
    }

    public ActivityItemData c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PbContent> list = this.s;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int size = this.s.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = this.s.get(i2);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && k() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = c.a.s0.u0.a.d(pbContent.text);
                    String str2 = pbContent.text;
                    activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                    return activityItemData;
                }
            }
            return null;
        }
        return (ActivityItemData) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!StringUtils.isNull(this.f40161g)) {
                str = this.f40161g;
            } else {
                str = (ListUtils.getItem(this.f40163i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f40163i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.f40163i, 0)).text;
            }
            return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title) : str;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public List<PbContent> e() {
        InterceptResult invokeV;
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.t.isEmpty() && (list = this.s) != null) {
                for (PbContent pbContent : list) {
                    if (pbContent.type.intValue() != 4) {
                        this.t.add(pbContent);
                    }
                }
            }
            return this.t;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public List<a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            if (baijiahaoData == null) {
                return false;
            }
            int i2 = baijiahaoData.oriUgcType;
            return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.k;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void m(OriginThreadInfo originThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, originThreadInfo) == null) {
            n(originThreadInfo, null);
        }
    }

    public void n(OriginThreadInfo originThreadInfo, @Nullable e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, originThreadInfo, e2Var) == null) {
            if (originThreadInfo == null) {
                q();
                return;
            }
            s(e2Var);
            this.f40158d = originThreadInfo.fname;
            this.f40159e = originThreadInfo.fid.longValue();
            this.f40160f = originThreadInfo.tid;
            this.f40161g = originThreadInfo.title;
            this.k = originThreadInfo.thread_type.intValue();
            this.s = originThreadInfo.content;
            this.y = originThreadInfo.author;
            this.z = originThreadInfo.agree;
            this.A = originThreadInfo.reply_num;
            this.B = originThreadInfo.shared_num;
            if (!ListUtils.isEmpty(originThreadInfo.media)) {
                this.f40162h = new ArrayList<>();
                for (Media media : originThreadInfo.media) {
                    if (media != null) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(media);
                        this.f40162h.add(mediaData);
                    }
                }
            } else {
                this.f40162h = null;
            }
            if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
                this.f40163i = new ArrayList();
                for (Abstract r1 : originThreadInfo._abstract) {
                    if (r1 != null) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parser(r1);
                        this.f40163i.add(abstractData);
                    }
                }
            } else {
                this.f40163i = null;
            }
            if (originThreadInfo.ala_info != null) {
                AlaInfoData alaInfoData = new AlaInfoData();
                this.f40164j = alaInfoData;
                alaInfoData.parserProtobuf(originThreadInfo.ala_info);
            } else {
                this.f40164j = null;
            }
            this.m = originThreadInfo.is_deleted.intValue() == 1;
            this.o = originThreadInfo.is_ugc.intValue() == 1;
            if (originThreadInfo.ori_ugc_info != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.p = baijiahaoData;
                baijiahaoData.parseProto(originThreadInfo.ori_ugc_info);
            }
            this.r = originThreadInfo.video_info;
            this.x = originThreadInfo.is_new_style.intValue() == 1;
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
                this.C = originThreadInfo.item;
            }
            if (this.C != null) {
                ItemData itemData = new ItemData();
                this.D = itemData;
                itemData.parseProto(this.C);
            }
            List<HeadItem> list = originThreadInfo.item_star;
            this.E = list;
            if (!ListUtils.isEmpty(list)) {
                ItemStarData itemStarData = new ItemStarData();
                this.F = itemStarData;
                itemStarData.parseProto(this.E);
            }
            if (originThreadInfo.poll_info != null) {
                PollData pollData = new PollData();
                this.G = pollData;
                pollData.parserProtobuf(originThreadInfo.poll_info);
            }
            this.H = originThreadInfo.is_frs_mask.intValue() == 1;
            r();
            o();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.v == null) {
                this.v = new ArrayList();
            }
            this.u = new SpannableString(e.G(this.s, this.E, true, this.w, this.v));
        }
    }

    public void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            if (jSONObject == null) {
                q();
                return;
            }
            try {
                this.f40158d = jSONObject.optString("fname");
                this.f40159e = jSONObject.optLong("fid", 0L);
                this.f40160f = jSONObject.optString("tid");
                this.f40161g = jSONObject.optString("title");
                this.k = jSONObject.optInt("thread_type");
                this.s = c1.a(jSONObject.optJSONArray("content"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
                if (optJSONObject != null) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    this.f40164j = alaInfoData;
                    alaInfoData.parserJson(optJSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
                if (optJSONArray != null) {
                    this.f40162h = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f40162h.add(mediaData);
                    }
                } else {
                    this.f40162h = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
                if (optJSONArray2 != null) {
                    this.f40163i = new ArrayList();
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f40163i.add(abstractData);
                    }
                } else {
                    this.f40163i = null;
                }
                boolean z = true;
                this.m = jSONObject.optInt("is_deleted") == 1;
                this.o = jSONObject.optInt("is_ugc") == 1;
                if (jSONObject.optInt("is_new_style") != 1) {
                    z = false;
                }
                this.x = z;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
                if (optJSONObject2 != null) {
                    BaijiahaoData baijiahaoData = new BaijiahaoData();
                    this.p = baijiahaoData;
                    baijiahaoData.parseJson(optJSONObject2);
                }
                this.r = n2.a(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    this.q = new ArrayList<>();
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                        voiceData$VoiceModel.parseJson(optJSONArray3.optJSONObject(i4));
                        this.q.add(voiceData$VoiceModel);
                    }
                }
                o();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a = 0;
            this.f40156b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            this.f40157c = null;
        }
    }

    public void r() {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i2 = this.k;
            if (i2 == 40) {
                this.a = 3;
            } else if (i2 == 54) {
                this.a = 2;
            } else if (i2 != 60 && i2 != 69 && i2 != 49 && i2 != 50) {
                this.a = 0;
            } else {
                this.a = 4;
            }
            if (ListUtils.getItem(this.f40162h, 0) != null) {
                String str = ((MediaData) ListUtils.getItem(this.f40162h, 0)).small_pic_url;
                this.f40157c = str;
                if (StringUtils.isNull(str)) {
                    this.f40157c = ((MediaData) ListUtils.getItem(this.f40162h, 0)).getPicUrl();
                }
            }
            if (StringUtils.isNull(this.f40157c) && (videoInfo = this.r) != null) {
                this.f40157c = videoInfo.thumbnail_url;
            }
            if (this.a == 0) {
                if (StringUtils.isNull(this.f40157c)) {
                    this.a = 0;
                } else {
                    this.a = 1;
                }
            }
            if (ListUtils.getItem(this.f40163i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f40163i, 0)).text)) {
                this.f40156b = ((AbstractData) ListUtils.getItem(this.f40163i, 0)).text;
            } else if (!StringUtils.isNull(this.f40161g)) {
                this.f40156b = this.f40161g;
            } else {
                this.f40156b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            }
        }
    }

    public void s(@Nullable e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            this.w = e2Var;
        }
    }

    /* loaded from: classes11.dex */
    public static class ShareInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemData itemData;
        public ItemStarData itemStarData;
        public BaijiahaoData oriUgcInfo;
        public PollData pollData;
        public String showPicUrl;
        public String showText;
        public int showType;
        public String threadId;
        public String videoId;

        public ShareInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static ShareInfo generateShareInfo(OriginalThreadInfo originalThreadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, originalThreadInfo)) == null) {
                ShareInfo shareInfo = new ShareInfo();
                shareInfo.threadId = originalThreadInfo.f40160f;
                shareInfo.showType = originalThreadInfo.a;
                shareInfo.showText = originalThreadInfo.f40156b;
                shareInfo.showPicUrl = originalThreadInfo.f40157c;
                shareInfo.videoId = originalThreadInfo.l;
                shareInfo.oriUgcInfo = originalThreadInfo.p;
                shareInfo.itemData = originalThreadInfo.D;
                shareInfo.itemStarData = originalThreadInfo.F;
                shareInfo.pollData = originalThreadInfo.G;
                return shareInfo;
            }
            return (ShareInfo) invokeL.objValue;
        }

        public static ShareInfo generateShareInfo(e2 e2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, e2Var)) == null) ? generateShareInfo(OriginalThreadInfo.l(e2Var)) : (ShareInfo) invokeL.objValue;
        }
    }
}
