package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.f1.n.e;
import c.a.q0.f1.p.a;
import c.a.q0.s.q.c1;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.m2;
import c.a.q0.s.q.r0;
import c.a.q0.t0.b;
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
/* loaded from: classes9.dex */
public class OriginalThreadInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer A;
    public Item B;
    public ItemData C;
    public List<HeadItem> D;
    public ItemStarData E;
    public PollData F;
    public boolean G;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f40900b;

    /* renamed from: c  reason: collision with root package name */
    public String f40901c;

    /* renamed from: d  reason: collision with root package name */
    public String f40902d;

    /* renamed from: e  reason: collision with root package name */
    public long f40903e;

    /* renamed from: f  reason: collision with root package name */
    public String f40904f;

    /* renamed from: g  reason: collision with root package name */
    public String f40905g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f40906h;

    /* renamed from: i  reason: collision with root package name */
    public List<AbstractData> f40907i;

    /* renamed from: j  reason: collision with root package name */
    public AlaInfoData f40908j;

    /* renamed from: k  reason: collision with root package name */
    public int f40909k;
    public String l;
    public boolean m;
    public String n;
    public boolean o;
    public BaijiahaoData p;
    public ArrayList<VoiceData$VoiceModel> q;
    public VideoInfo r;
    public List<PbContent> s;
    public SpannableString t;
    @Nullable
    public List<a> u;
    @Nullable
    public d2 v;
    public boolean w;
    public User x;
    public Agree y;
    public Integer z;

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
    }

    public static OriginalThreadInfo k(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            OriginalThreadInfo originalThreadInfo = d2Var.A1;
            if (originalThreadInfo != null) {
                return originalThreadInfo;
            }
            OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
            originalThreadInfo2.r(d2Var);
            originalThreadInfo2.f40902d = d2Var.a0();
            originalThreadInfo2.f40903e = d2Var.U();
            originalThreadInfo2.f40904f = d2Var.v1();
            originalThreadInfo2.f40905g = d2Var.getTitle();
            originalThreadInfo2.f40909k = d2Var.r1();
            ArrayList arrayList = new ArrayList();
            AbstractData abstractData = new AbstractData();
            abstractData.text = d2Var.o();
            arrayList.add(abstractData);
            originalThreadInfo2.f40907i = arrayList;
            ArrayList<MediaData> arrayList2 = new ArrayList<>();
            MediaData mediaData = new MediaData();
            arrayList2.add(mediaData);
            originalThreadInfo2.f40906h = arrayList2;
            originalThreadInfo2.r = d2Var.t1();
            if (d2Var.h2() && d2Var.C0() != null) {
                r0 C0 = d2Var.C0();
                originalThreadInfo2.f40905g = C0.d();
                abstractData.text = C0.a();
                mediaData.setPic(C0.b());
            } else if (d2Var.g2() && d2Var.m1() != null) {
                mediaData.setPic(d2Var.m1().i());
            } else if (ListUtils.getCount(d2Var.F0()) > 0) {
                originalThreadInfo2.f40906h = d2Var.F0();
            } else if (d2Var.t1() != null && !StringUtils.isNull(d2Var.t1().thumbnail_url)) {
                mediaData.setPic(d2Var.t1().thumbnail_url);
            }
            originalThreadInfo2.f40908j = d2Var.o1();
            originalThreadInfo2.q();
            originalThreadInfo2.C = d2Var.C2;
            originalThreadInfo2.E = d2Var.E2;
            originalThreadInfo2.p = d2Var.L();
            originalThreadInfo2.F = d2Var.J0();
            return originalThreadInfo2;
        }
        return (OriginalThreadInfo) invokeL.objValue;
    }

    public d2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d2 d2Var = new d2();
            d2Var.F4(this.f40905g);
            if (this.f40906h != null) {
                d2Var.m4(new ArrayList<>(this.f40906h));
            }
            d2Var.M3(this.f40902d);
            d2Var.E4(this.f40904f);
            d2Var.B4(this.f40908j);
            d2Var.I3(this.f40903e);
            d2Var.D4(this.f40909k);
            d2Var.B1 = true;
            d2Var.C3(this.p);
            d2Var.K4(this.r);
            d2Var.A3(this.f40901c);
            d2Var.A1 = this;
            return d2Var;
        }
        return (d2) invokeV.objValue;
    }

    @Nullable
    public SpannableString b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : (SpannableString) invokeV.objValue;
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
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && j() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = b.d(pbContent.text);
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
            if (!StringUtils.isNull(this.f40905g)) {
                str = this.f40905g;
            } else {
                str = (ListUtils.getItem(this.f40907i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f40907i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.f40907i, 0)).text;
            }
            return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title) : str;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public List<a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u : (List) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            if (baijiahaoData == null) {
                return false;
            }
            int i2 = baijiahaoData.oriUgcType;
            return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f40909k;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void l(OriginThreadInfo originThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, originThreadInfo) == null) {
            m(originThreadInfo, null);
        }
    }

    public void m(OriginThreadInfo originThreadInfo, @Nullable d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, originThreadInfo, d2Var) == null) {
            if (originThreadInfo == null) {
                p();
                return;
            }
            r(d2Var);
            this.f40902d = originThreadInfo.fname;
            this.f40903e = originThreadInfo.fid.longValue();
            this.f40904f = originThreadInfo.tid;
            this.f40905g = originThreadInfo.title;
            this.f40909k = originThreadInfo.thread_type.intValue();
            this.s = originThreadInfo.content;
            this.x = originThreadInfo.author;
            this.y = originThreadInfo.agree;
            this.z = originThreadInfo.reply_num;
            this.A = originThreadInfo.shared_num;
            if (!ListUtils.isEmpty(originThreadInfo.media)) {
                this.f40906h = new ArrayList<>();
                for (Media media : originThreadInfo.media) {
                    if (media != null) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(media);
                        this.f40906h.add(mediaData);
                    }
                }
            } else {
                this.f40906h = null;
            }
            if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
                this.f40907i = new ArrayList();
                for (Abstract r1 : originThreadInfo._abstract) {
                    if (r1 != null) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parser(r1);
                        this.f40907i.add(abstractData);
                    }
                }
            } else {
                this.f40907i = null;
            }
            if (originThreadInfo.ala_info != null) {
                AlaInfoData alaInfoData = new AlaInfoData();
                this.f40908j = alaInfoData;
                alaInfoData.parserProtobuf(originThreadInfo.ala_info);
            } else {
                this.f40908j = null;
            }
            this.m = originThreadInfo.is_deleted.intValue() == 1;
            this.o = originThreadInfo.is_ugc.intValue() == 1;
            if (originThreadInfo.ori_ugc_info != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.p = baijiahaoData;
                baijiahaoData.parseProto(originThreadInfo.ori_ugc_info);
            }
            this.r = originThreadInfo.video_info;
            this.w = originThreadInfo.is_new_style.intValue() == 1;
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
                this.B = originThreadInfo.item;
            }
            if (this.B != null) {
                ItemData itemData = new ItemData();
                this.C = itemData;
                itemData.parseProto(this.B);
            }
            List<HeadItem> list = originThreadInfo.item_star;
            this.D = list;
            if (!ListUtils.isEmpty(list)) {
                ItemStarData itemStarData = new ItemStarData();
                this.E = itemStarData;
                itemStarData.parseProto(this.D);
            }
            if (originThreadInfo.poll_info != null) {
                PollData pollData = new PollData();
                this.F = pollData;
                pollData.parserProtobuf(originThreadInfo.poll_info);
            }
            this.G = originThreadInfo.is_frs_mask.intValue() == 1;
            q();
            n();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.u == null) {
                this.u = new ArrayList();
            }
            this.t = new SpannableString(e.G(this.s, this.D, true, this.v, this.u));
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            if (jSONObject == null) {
                p();
                return;
            }
            try {
                this.f40902d = jSONObject.optString("fname");
                this.f40903e = jSONObject.optLong("fid", 0L);
                this.f40904f = jSONObject.optString("tid");
                this.f40905g = jSONObject.optString("title");
                this.f40909k = jSONObject.optInt("thread_type");
                this.s = c1.a(jSONObject.optJSONArray("content"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
                if (optJSONObject != null) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    this.f40908j = alaInfoData;
                    alaInfoData.parserJson(optJSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
                if (optJSONArray != null) {
                    this.f40906h = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f40906h.add(mediaData);
                    }
                } else {
                    this.f40906h = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
                if (optJSONArray2 != null) {
                    this.f40907i = new ArrayList();
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f40907i.add(abstractData);
                    }
                } else {
                    this.f40907i = null;
                }
                boolean z = true;
                this.m = jSONObject.optInt("is_deleted") == 1;
                this.o = jSONObject.optInt("is_ugc") == 1;
                if (jSONObject.optInt("is_new_style") != 1) {
                    z = false;
                }
                this.w = z;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
                if (optJSONObject2 != null) {
                    BaijiahaoData baijiahaoData = new BaijiahaoData();
                    this.p = baijiahaoData;
                    baijiahaoData.parseJson(optJSONObject2);
                }
                this.r = m2.a(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    this.q = new ArrayList<>();
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                        voiceData$VoiceModel.parseJson(optJSONArray3.optJSONObject(i4));
                        this.q.add(voiceData$VoiceModel);
                    }
                }
                n();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a = 0;
            this.f40900b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            this.f40901c = null;
        }
    }

    public void q() {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.f40909k;
            if (i2 == 40) {
                this.a = 3;
            } else if (i2 == 54) {
                this.a = 2;
            } else if (i2 != 60 && i2 != 69 && i2 != 49 && i2 != 50) {
                this.a = 0;
            } else {
                this.a = 4;
            }
            if (ListUtils.getItem(this.f40906h, 0) != null) {
                String str = ((MediaData) ListUtils.getItem(this.f40906h, 0)).small_pic_url;
                this.f40901c = str;
                if (StringUtils.isNull(str)) {
                    this.f40901c = ((MediaData) ListUtils.getItem(this.f40906h, 0)).getPicUrl();
                }
            }
            if (StringUtils.isNull(this.f40901c) && (videoInfo = this.r) != null) {
                this.f40901c = videoInfo.thumbnail_url;
            }
            if (this.a == 0) {
                if (StringUtils.isNull(this.f40901c)) {
                    this.a = 0;
                } else {
                    this.a = 1;
                }
            }
            if (ListUtils.getItem(this.f40907i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f40907i, 0)).text)) {
                this.f40900b = ((AbstractData) ListUtils.getItem(this.f40907i, 0)).text;
            } else if (!StringUtils.isNull(this.f40905g)) {
                this.f40900b = this.f40905g;
            } else {
                this.f40900b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            }
        }
    }

    public void r(@Nullable d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d2Var) == null) {
            this.v = d2Var;
        }
    }

    /* loaded from: classes9.dex */
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
                shareInfo.threadId = originalThreadInfo.f40904f;
                shareInfo.showType = originalThreadInfo.a;
                shareInfo.showText = originalThreadInfo.f40900b;
                shareInfo.showPicUrl = originalThreadInfo.f40901c;
                shareInfo.videoId = originalThreadInfo.l;
                shareInfo.oriUgcInfo = originalThreadInfo.p;
                shareInfo.itemData = originalThreadInfo.C;
                shareInfo.itemStarData = originalThreadInfo.E;
                shareInfo.pollData = originalThreadInfo.F;
                return shareInfo;
            }
            return (ShareInfo) invokeL.objValue;
        }

        public static ShareInfo generateShareInfo(d2 d2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, d2Var)) == null) ? generateShareInfo(OriginalThreadInfo.k(d2Var)) : (ShareInfo) invokeL.objValue;
        }
    }
}
