package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import d.a.r0.b1.m.e;
import d.a.r0.p0.b;
import d.a.r0.r.q.b1;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.k2;
import d.a.r0.r.q.q0;
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
/* loaded from: classes4.dex */
public class OriginalThreadInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemData A;
    public List<HeadItem> B;
    public ItemStarData C;
    public PollData D;

    /* renamed from: a  reason: collision with root package name */
    public int f12230a;

    /* renamed from: b  reason: collision with root package name */
    public String f12231b;

    /* renamed from: c  reason: collision with root package name */
    public String f12232c;

    /* renamed from: d  reason: collision with root package name */
    public String f12233d;

    /* renamed from: e  reason: collision with root package name */
    public long f12234e;

    /* renamed from: f  reason: collision with root package name */
    public String f12235f;

    /* renamed from: g  reason: collision with root package name */
    public String f12236g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f12237h;

    /* renamed from: i  reason: collision with root package name */
    public List<AbstractData> f12238i;
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
    public boolean u;
    public User v;
    public Agree w;
    public Integer x;
    public Integer y;
    public Item z;

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

    public static OriginalThreadInfo i(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            OriginalThreadInfo originalThreadInfo = b2Var.u1;
            if (originalThreadInfo != null) {
                return originalThreadInfo;
            }
            OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
            originalThreadInfo2.f12233d = b2Var.W();
            originalThreadInfo2.f12234e = b2Var.Q();
            originalThreadInfo2.f12235f = b2Var.n1();
            originalThreadInfo2.f12236g = b2Var.getTitle();
            originalThreadInfo2.k = b2Var.j1();
            ArrayList arrayList = new ArrayList();
            AbstractData abstractData = new AbstractData();
            abstractData.text = b2Var.h();
            arrayList.add(abstractData);
            originalThreadInfo2.f12238i = arrayList;
            ArrayList<MediaData> arrayList2 = new ArrayList<>();
            MediaData mediaData = new MediaData();
            arrayList2.add(mediaData);
            originalThreadInfo2.f12237h = arrayList2;
            originalThreadInfo2.r = b2Var.l1();
            if (b2Var.V1() && b2Var.w0() != null) {
                q0 w0 = b2Var.w0();
                originalThreadInfo2.f12236g = w0.d();
                abstractData.text = w0.a();
                mediaData.setPic(w0.b());
            } else if (b2Var.U1() && b2Var.e1() != null) {
                mediaData.setPic(b2Var.e1().i());
            } else if (ListUtils.getCount(b2Var.z0()) > 0) {
                originalThreadInfo2.f12237h = b2Var.z0();
            } else if (b2Var.l1() != null && !StringUtils.isNull(b2Var.l1().thumbnail_url)) {
                mediaData.setPic(b2Var.l1().thumbnail_url);
            }
            originalThreadInfo2.j = b2Var.g1();
            originalThreadInfo2.n();
            originalThreadInfo2.A = b2Var.v2;
            originalThreadInfo2.C = b2Var.x2;
            originalThreadInfo2.p = b2Var.J();
            originalThreadInfo2.D = b2Var.D0();
            return originalThreadInfo2;
        }
        return (OriginalThreadInfo) invokeL.objValue;
    }

    public b2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b2 b2Var = new b2();
            b2Var.f4(this.f12236g);
            if (this.f12237h != null) {
                b2Var.M3(new ArrayList<>(this.f12237h));
            }
            b2Var.p3(this.f12233d);
            b2Var.e4(this.f12235f);
            b2Var.b4(this.j);
            b2Var.l3(this.f12234e);
            b2Var.d4(this.k);
            b2Var.v1 = true;
            b2Var.i3(this.p);
            b2Var.j4(this.r);
            b2Var.g3(this.f12232c);
            b2Var.u1 = this;
            return b2Var;
        }
        return (b2) invokeV.objValue;
    }

    public ActivityItemData b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (ActivityItemData) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!StringUtils.isNull(this.f12236g)) {
                str = this.f12236g;
            } else {
                str = (ListUtils.getItem(this.f12238i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f12238i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.f12238i, 0)).text;
            }
            return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title) : str;
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BaijiahaoData baijiahaoData = this.p;
            if (baijiahaoData == null) {
                return false;
            }
            int i2 = baijiahaoData.oriUgcType;
            return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.k;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void j(OriginThreadInfo originThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, originThreadInfo) == null) {
            if (originThreadInfo == null) {
                m();
                return;
            }
            this.f12233d = originThreadInfo.fname;
            this.f12234e = originThreadInfo.fid.longValue();
            this.f12235f = originThreadInfo.tid;
            this.f12236g = originThreadInfo.title;
            this.k = originThreadInfo.thread_type.intValue();
            this.s = originThreadInfo.content;
            this.v = originThreadInfo.author;
            this.w = originThreadInfo.agree;
            this.x = originThreadInfo.reply_num;
            this.y = originThreadInfo.shared_num;
            if (!ListUtils.isEmpty(originThreadInfo.media)) {
                this.f12237h = new ArrayList<>();
                for (Media media : originThreadInfo.media) {
                    if (media != null) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(media);
                        this.f12237h.add(mediaData);
                    }
                }
            } else {
                this.f12237h = null;
            }
            if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
                this.f12238i = new ArrayList();
                for (Abstract r2 : originThreadInfo._abstract) {
                    if (r2 != null) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parser(r2);
                        this.f12238i.add(abstractData);
                    }
                }
            } else {
                this.f12238i = null;
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
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.t = new SpannableString(e.A(this.s, this.B, true));
        }
    }

    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            if (jSONObject == null) {
                m();
                return;
            }
            try {
                this.f12233d = jSONObject.optString("fname");
                this.f12234e = jSONObject.optLong("fid", 0L);
                this.f12235f = jSONObject.optString("tid");
                this.f12236g = jSONObject.optString("title");
                this.k = jSONObject.optInt("thread_type");
                this.s = b1.a(jSONObject.optJSONArray("content"));
                JSONObject optJSONObject = jSONObject.optJSONObject("ala_info");
                if (optJSONObject != null) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    this.j = alaInfoData;
                    alaInfoData.parserJson(optJSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
                if (optJSONArray != null) {
                    this.f12237h = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f12237h.add(mediaData);
                    }
                } else {
                    this.f12237h = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
                if (optJSONArray2 != null) {
                    this.f12238i = new ArrayList();
                    int length2 = optJSONArray2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f12238i.add(abstractData);
                    }
                } else {
                    this.f12238i = null;
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
                this.r = k2.a(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
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
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f12230a = 0;
            this.f12231b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            this.f12232c = null;
        }
    }

    public void n() {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i2 = this.k;
            if (i2 == 40) {
                this.f12230a = 3;
            } else if (i2 == 54) {
                this.f12230a = 2;
            } else if (i2 != 60 && i2 != 69 && i2 != 49 && i2 != 50) {
                this.f12230a = 0;
            } else {
                this.f12230a = 4;
            }
            if (ListUtils.getItem(this.f12237h, 0) != null) {
                String str = ((MediaData) ListUtils.getItem(this.f12237h, 0)).small_pic_url;
                this.f12232c = str;
                if (StringUtils.isNull(str)) {
                    this.f12232c = ((MediaData) ListUtils.getItem(this.f12237h, 0)).getPicUrl();
                }
            }
            if (StringUtils.isNull(this.f12232c) && (videoInfo = this.r) != null) {
                this.f12232c = videoInfo.thumbnail_url;
            }
            if (this.f12230a == 0) {
                if (StringUtils.isNull(this.f12232c)) {
                    this.f12230a = 0;
                } else {
                    this.f12230a = 1;
                }
            }
            if (ListUtils.getItem(this.f12238i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.f12238i, 0)).text)) {
                this.f12231b = ((AbstractData) ListUtils.getItem(this.f12238i, 0)).text;
            } else if (!StringUtils.isNull(this.f12236g)) {
                this.f12231b = this.f12236g;
            } else {
                this.f12231b = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, originalThreadInfo)) == null) {
                ShareInfo shareInfo = new ShareInfo();
                shareInfo.threadId = originalThreadInfo.f12235f;
                shareInfo.showType = originalThreadInfo.f12230a;
                shareInfo.showText = originalThreadInfo.f12231b;
                shareInfo.showPicUrl = originalThreadInfo.f12232c;
                shareInfo.videoId = originalThreadInfo.l;
                shareInfo.oriUgcInfo = originalThreadInfo.p;
                shareInfo.itemData = originalThreadInfo.A;
                shareInfo.itemStarData = originalThreadInfo.C;
                shareInfo.pollData = originalThreadInfo.D;
                return shareInfo;
            }
            return (ShareInfo) invokeL.objValue;
        }

        public static ShareInfo generateShareInfo(b2 b2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b2Var)) == null) ? generateShareInfo(OriginalThreadInfo.i(b2Var)) : (ShareInfo) invokeL.objValue;
        }
    }
}
