package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.f1.n.e;
import b.a.q0.f1.p.a;
import b.a.q0.s.q.c1;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.m2;
import b.a.q0.s.q.r0;
import b.a.q0.t0.b;
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
/* loaded from: classes8.dex */
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

    /* renamed from: a  reason: collision with root package name */
    public int f45035a;

    /* renamed from: b  reason: collision with root package name */
    public String f45036b;

    /* renamed from: c  reason: collision with root package name */
    public String f45037c;

    /* renamed from: d  reason: collision with root package name */
    public String f45038d;

    /* renamed from: e  reason: collision with root package name */
    public long f45039e;

    /* renamed from: f  reason: collision with root package name */
    public String f45040f;

    /* renamed from: g  reason: collision with root package name */
    public String f45041g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f45042h;

    /* renamed from: i  reason: collision with root package name */
    public List<AbstractData> f45043i;
    public AlaInfoData j;
    public int k;
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
            OriginalThreadInfo originalThreadInfo = d2Var.y1;
            if (originalThreadInfo != null) {
                return originalThreadInfo;
            }
            OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
            originalThreadInfo2.r(d2Var);
            originalThreadInfo2.f45038d = d2Var.Z();
            originalThreadInfo2.f45039e = d2Var.T();
            originalThreadInfo2.f45040f = d2Var.s1();
            originalThreadInfo2.f45041g = d2Var.getTitle();
            originalThreadInfo2.k = d2Var.o1();
            ArrayList arrayList = new ArrayList();
            AbstractData abstractData = new AbstractData();
            abstractData.text = d2Var.o();
            arrayList.add(abstractData);
            originalThreadInfo2.f45043i = arrayList;
            ArrayList<MediaData> arrayList2 = new ArrayList<>();
            MediaData mediaData = new MediaData();
            arrayList2.add(mediaData);
            originalThreadInfo2.f45042h = arrayList2;
            originalThreadInfo2.r = d2Var.q1();
            if (d2Var.e2() && d2Var.B0() != null) {
                r0 B0 = d2Var.B0();
                originalThreadInfo2.f45041g = B0.d();
                abstractData.text = B0.a();
                mediaData.setPic(B0.b());
            } else if (d2Var.d2() && d2Var.j1() != null) {
                mediaData.setPic(d2Var.j1().i());
            } else if (ListUtils.getCount(d2Var.E0()) > 0) {
                originalThreadInfo2.f45042h = d2Var.E0();
            } else if (d2Var.q1() != null && !StringUtils.isNull(d2Var.q1().thumbnail_url)) {
                mediaData.setPic(d2Var.q1().thumbnail_url);
            }
            originalThreadInfo2.j = d2Var.l1();
            originalThreadInfo2.q();
            originalThreadInfo2.C = d2Var.z2;
            originalThreadInfo2.E = d2Var.B2;
            originalThreadInfo2.p = d2Var.L();
            originalThreadInfo2.F = d2Var.I0();
            return originalThreadInfo2;
        }
        return (OriginalThreadInfo) invokeL.objValue;
    }

    public d2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d2 d2Var = new d2();
            d2Var.B4(this.f45041g);
            if (this.f45042h != null) {
                d2Var.i4(new ArrayList<>(this.f45042h));
            }
            d2Var.I3(this.f45038d);
            d2Var.A4(this.f45040f);
            d2Var.x4(this.j);
            d2Var.E3(this.f45039e);
            d2Var.z4(this.k);
            d2Var.z1 = true;
            d2Var.y3(this.p);
            d2Var.G4(this.r);
            d2Var.w3(this.f45037c);
            d2Var.y1 = this;
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
            if (!StringUtils.isNull(this.f45041g)) {
                str = this.f45041g;
            } else {
                str = (ListUtils.getItem(this.f45043i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f45043i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.f45043i, 0)).text;
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
            int i2 = this.k;
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
            this.f45038d = originThreadInfo.fname;
            this.f45039e = originThreadInfo.fid.longValue();
            this.f45040f = originThreadInfo.tid;
            this.f45041g = originThreadInfo.title;
            this.k = originThreadInfo.thread_type.intValue();
            this.s = originThreadInfo.content;
            this.x = originThreadInfo.author;
            this.y = originThreadInfo.agree;
            this.z = originThreadInfo.reply_num;
            this.A = originThreadInfo.shared_num;
            if (!ListUtils.isEmpty(originThreadInfo.media)) {
                this.f45042h = new ArrayList<>();
                for (Media media : originThreadInfo.media) {
                    if (media != null) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(media);
                        this.f45042h.add(mediaData);
                    }
                }
            } else {
                this.f45042h = null;
            }
            if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
                this.f45043i = new ArrayList();
                for (Abstract r1 : originThreadInfo._abstract) {
                    if (r1 != null) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parser(r1);
                        this.f45043i.add(abstractData);
                    }
                }
            } else {
                this.f45043i = null;
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
                this.f45038d = jSONObject.optString("fname");
                this.f45039e = jSONObject.optLong("fid", 0L);
                this.f45040f = jSONObject.optString("tid");
                this.f45041g = jSONObject.optString("title");
                this.k = jSONObject.optInt("thread_type");
                this.s = c1.a(jSONObject.optJSONArray("content"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
                if (optJSONObject != null) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    this.j = alaInfoData;
                    alaInfoData.parserJson(optJSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
                if (optJSONArray != null) {
                    this.f45042h = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f45042h.add(mediaData);
                    }
                } else {
                    this.f45042h = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
                if (optJSONArray2 != null) {
                    this.f45043i = new ArrayList();
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f45043i.add(abstractData);
                    }
                } else {
                    this.f45043i = null;
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
            this.f45035a = 0;
            this.f45036b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            this.f45037c = null;
        }
    }

    public void q() {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.k;
            if (i2 == 40) {
                this.f45035a = 3;
            } else if (i2 == 54) {
                this.f45035a = 2;
            } else if (i2 != 60 && i2 != 69 && i2 != 49 && i2 != 50) {
                this.f45035a = 0;
            } else {
                this.f45035a = 4;
            }
            if (ListUtils.getItem(this.f45042h, 0) != null) {
                String str = ((MediaData) ListUtils.getItem(this.f45042h, 0)).small_pic_url;
                this.f45037c = str;
                if (StringUtils.isNull(str)) {
                    this.f45037c = ((MediaData) ListUtils.getItem(this.f45042h, 0)).getPicUrl();
                }
            }
            if (StringUtils.isNull(this.f45037c) && (videoInfo = this.r) != null) {
                this.f45037c = videoInfo.thumbnail_url;
            }
            if (this.f45035a == 0) {
                if (StringUtils.isNull(this.f45037c)) {
                    this.f45035a = 0;
                } else {
                    this.f45035a = 1;
                }
            }
            if (ListUtils.getItem(this.f45043i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f45043i, 0)).text)) {
                this.f45036b = ((AbstractData) ListUtils.getItem(this.f45043i, 0)).text;
            } else if (!StringUtils.isNull(this.f45041g)) {
                this.f45036b = this.f45041g;
            } else {
                this.f45036b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            }
        }
    }

    public void r(@Nullable d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d2Var) == null) {
            this.v = d2Var;
        }
    }

    /* loaded from: classes8.dex */
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
                shareInfo.threadId = originalThreadInfo.f45040f;
                shareInfo.showType = originalThreadInfo.f45035a;
                shareInfo.showText = originalThreadInfo.f45036b;
                shareInfo.showPicUrl = originalThreadInfo.f45037c;
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
