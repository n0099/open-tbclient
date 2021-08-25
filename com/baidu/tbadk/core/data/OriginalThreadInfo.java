package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.d1.o.a;
import c.a.p0.r0.b;
import c.a.p0.s.q.c1;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.l2;
import c.a.p0.s.q.r0;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichTextHelper;
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
/* loaded from: classes6.dex */
public class OriginalThreadInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer A;
    public Item B;
    public ItemData C;
    public List<HeadItem> D;
    public ItemStarData E;
    public PollData F;

    /* renamed from: a  reason: collision with root package name */
    public int f47301a;

    /* renamed from: b  reason: collision with root package name */
    public String f47302b;

    /* renamed from: c  reason: collision with root package name */
    public String f47303c;

    /* renamed from: d  reason: collision with root package name */
    public String f47304d;

    /* renamed from: e  reason: collision with root package name */
    public long f47305e;

    /* renamed from: f  reason: collision with root package name */
    public String f47306f;

    /* renamed from: g  reason: collision with root package name */
    public String f47307g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f47308h;

    /* renamed from: i  reason: collision with root package name */
    public List<AbstractData> f47309i;

    /* renamed from: j  reason: collision with root package name */
    public AlaInfoData f47310j;
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
    public c2 v;
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

    public static OriginalThreadInfo k(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c2Var)) == null) {
            if (c2Var == null) {
                return null;
            }
            OriginalThreadInfo originalThreadInfo = c2Var.v1;
            if (originalThreadInfo != null) {
                return originalThreadInfo;
            }
            OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
            originalThreadInfo2.r(c2Var);
            originalThreadInfo2.f47304d = c2Var.Z();
            originalThreadInfo2.f47305e = c2Var.T();
            originalThreadInfo2.f47306f = c2Var.q1();
            originalThreadInfo2.f47307g = c2Var.getTitle();
            originalThreadInfo2.k = c2Var.m1();
            ArrayList arrayList = new ArrayList();
            AbstractData abstractData = new AbstractData();
            abstractData.text = c2Var.o();
            arrayList.add(abstractData);
            originalThreadInfo2.f47309i = arrayList;
            ArrayList<MediaData> arrayList2 = new ArrayList<>();
            MediaData mediaData = new MediaData();
            arrayList2.add(mediaData);
            originalThreadInfo2.f47308h = arrayList2;
            originalThreadInfo2.r = c2Var.o1();
            if (c2Var.b2() && c2Var.z0() != null) {
                r0 z0 = c2Var.z0();
                originalThreadInfo2.f47307g = z0.d();
                abstractData.text = z0.a();
                mediaData.setPic(z0.b());
            } else if (c2Var.a2() && c2Var.h1() != null) {
                mediaData.setPic(c2Var.h1().i());
            } else if (ListUtils.getCount(c2Var.C0()) > 0) {
                originalThreadInfo2.f47308h = c2Var.C0();
            } else if (c2Var.o1() != null && !StringUtils.isNull(c2Var.o1().thumbnail_url)) {
                mediaData.setPic(c2Var.o1().thumbnail_url);
            }
            originalThreadInfo2.f47310j = c2Var.j1();
            originalThreadInfo2.q();
            originalThreadInfo2.C = c2Var.w2;
            originalThreadInfo2.E = c2Var.y2;
            originalThreadInfo2.p = c2Var.L();
            originalThreadInfo2.F = c2Var.G0();
            return originalThreadInfo2;
        }
        return (OriginalThreadInfo) invokeL.objValue;
    }

    public c2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c2 c2Var = new c2();
            c2Var.r4(this.f47307g);
            if (this.f47308h != null) {
                c2Var.Y3(new ArrayList<>(this.f47308h));
            }
            c2Var.B3(this.f47304d);
            c2Var.q4(this.f47306f);
            c2Var.n4(this.f47310j);
            c2Var.x3(this.f47305e);
            c2Var.p4(this.k);
            c2Var.w1 = true;
            c2Var.s3(this.p);
            c2Var.v4(this.r);
            c2Var.q3(this.f47303c);
            c2Var.v1 = this;
            return c2Var;
        }
        return (c2) invokeV.objValue;
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
            if (!StringUtils.isNull(this.f47307g)) {
                str = this.f47307g;
            } else {
                str = (ListUtils.getItem(this.f47309i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f47309i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.f47309i, 0)).text;
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

    public void m(OriginThreadInfo originThreadInfo, @Nullable c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, originThreadInfo, c2Var) == null) {
            if (originThreadInfo == null) {
                p();
                return;
            }
            r(c2Var);
            this.f47304d = originThreadInfo.fname;
            this.f47305e = originThreadInfo.fid.longValue();
            this.f47306f = originThreadInfo.tid;
            this.f47307g = originThreadInfo.title;
            this.k = originThreadInfo.thread_type.intValue();
            this.s = originThreadInfo.content;
            this.x = originThreadInfo.author;
            this.y = originThreadInfo.agree;
            this.z = originThreadInfo.reply_num;
            this.A = originThreadInfo.shared_num;
            if (!ListUtils.isEmpty(originThreadInfo.media)) {
                this.f47308h = new ArrayList<>();
                for (Media media : originThreadInfo.media) {
                    if (media != null) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(media);
                        this.f47308h.add(mediaData);
                    }
                }
            } else {
                this.f47308h = null;
            }
            if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
                this.f47309i = new ArrayList();
                for (Abstract r1 : originThreadInfo._abstract) {
                    if (r1 != null) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parser(r1);
                        this.f47309i.add(abstractData);
                    }
                }
            } else {
                this.f47309i = null;
            }
            if (originThreadInfo.ala_info != null) {
                AlaInfoData alaInfoData = new AlaInfoData();
                this.f47310j = alaInfoData;
                alaInfoData.parserProtobuf(originThreadInfo.ala_info);
            } else {
                this.f47310j = null;
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
            this.t = new SpannableString(TbRichTextHelper.E(this.s, this.D, true, this.v, this.u));
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
                this.f47304d = jSONObject.optString("fname");
                this.f47305e = jSONObject.optLong("fid", 0L);
                this.f47306f = jSONObject.optString("tid");
                this.f47307g = jSONObject.optString("title");
                this.k = jSONObject.optInt("thread_type");
                this.s = c1.a(jSONObject.optJSONArray("content"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
                if (optJSONObject != null) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    this.f47310j = alaInfoData;
                    alaInfoData.parserJson(optJSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
                if (optJSONArray != null) {
                    this.f47308h = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f47308h.add(mediaData);
                    }
                } else {
                    this.f47308h = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
                if (optJSONArray2 != null) {
                    this.f47309i = new ArrayList();
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f47309i.add(abstractData);
                    }
                } else {
                    this.f47309i = null;
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
                this.r = l2.a(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
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
            this.f47301a = 0;
            this.f47302b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            this.f47303c = null;
        }
    }

    public void q() {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.k;
            if (i2 == 40) {
                this.f47301a = 3;
            } else if (i2 == 54) {
                this.f47301a = 2;
            } else if (i2 != 60 && i2 != 69 && i2 != 49 && i2 != 50) {
                this.f47301a = 0;
            } else {
                this.f47301a = 4;
            }
            if (ListUtils.getItem(this.f47308h, 0) != null) {
                String str = ((MediaData) ListUtils.getItem(this.f47308h, 0)).small_pic_url;
                this.f47303c = str;
                if (StringUtils.isNull(str)) {
                    this.f47303c = ((MediaData) ListUtils.getItem(this.f47308h, 0)).getPicUrl();
                }
            }
            if (StringUtils.isNull(this.f47303c) && (videoInfo = this.r) != null) {
                this.f47303c = videoInfo.thumbnail_url;
            }
            if (this.f47301a == 0) {
                if (StringUtils.isNull(this.f47303c)) {
                    this.f47301a = 0;
                } else {
                    this.f47301a = 1;
                }
            }
            if (ListUtils.getItem(this.f47309i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f47309i, 0)).text)) {
                this.f47302b = ((AbstractData) ListUtils.getItem(this.f47309i, 0)).text;
            } else if (!StringUtils.isNull(this.f47307g)) {
                this.f47302b = this.f47307g;
            } else {
                this.f47302b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            }
        }
    }

    public void r(@Nullable c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, c2Var) == null) {
            this.v = c2Var;
        }
    }

    /* loaded from: classes6.dex */
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
                shareInfo.threadId = originalThreadInfo.f47306f;
                shareInfo.showType = originalThreadInfo.f47301a;
                shareInfo.showText = originalThreadInfo.f47302b;
                shareInfo.showPicUrl = originalThreadInfo.f47303c;
                shareInfo.videoId = originalThreadInfo.l;
                shareInfo.oriUgcInfo = originalThreadInfo.p;
                shareInfo.itemData = originalThreadInfo.C;
                shareInfo.itemStarData = originalThreadInfo.E;
                shareInfo.pollData = originalThreadInfo.F;
                return shareInfo;
            }
            return (ShareInfo) invokeL.objValue;
        }

        public static ShareInfo generateShareInfo(c2 c2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c2Var)) == null) ? generateShareInfo(OriginalThreadInfo.k(c2Var)) : (ShareInfo) invokeL.objValue;
        }
    }
}
