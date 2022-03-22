package com.baidu.tbadk.core.data;

import android.text.SpannableString;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.e1.n.e;
import c.a.o0.e1.p.c;
import c.a.o0.r.r.a1;
import c.a.o0.r.r.h2;
import c.a.o0.r.r.q0;
import c.a.o0.t0.a;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
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
/* loaded from: classes4.dex */
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
    public String f29822b;

    /* renamed from: c  reason: collision with root package name */
    public String f29823c;

    /* renamed from: d  reason: collision with root package name */
    public String f29824d;

    /* renamed from: e  reason: collision with root package name */
    public long f29825e;

    /* renamed from: f  reason: collision with root package name */
    public String f29826f;

    /* renamed from: g  reason: collision with root package name */
    public String f29827g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaData> f29828h;
    public List<AbstractData> i;
    public AlaInfoData j;
    public int k;
    public String l;
    public boolean m;
    public String n;
    public boolean o;
    public BaijiahaoData p;
    public ArrayList<VoiceData.VoiceModel> q;
    public VideoInfo r;
    public List<PbContent> s;
    @NonNull
    public final List<PbContent> t;
    public SpannableString u;
    @Nullable
    public List<c> v;
    @Nullable
    public ThreadData w;
    public boolean x;
    public User y;
    public Agree z;

    public OriginalThreadInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.t = new ArrayList();
    }

    public static OriginalThreadInfo l(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
            if (originalThreadInfo != null) {
                return originalThreadInfo;
            }
            OriginalThreadInfo originalThreadInfo2 = new OriginalThreadInfo();
            originalThreadInfo2.s(threadData);
            originalThreadInfo2.f29824d = threadData.getForum_name();
            originalThreadInfo2.f29825e = threadData.getFid();
            originalThreadInfo2.f29826f = threadData.getTid();
            originalThreadInfo2.f29827g = threadData.getTitle();
            originalThreadInfo2.k = threadData.getThreadType();
            ArrayList arrayList = new ArrayList();
            AbstractData abstractData = new AbstractData();
            abstractData.text = threadData.getAbstract();
            arrayList.add(abstractData);
            originalThreadInfo2.i = arrayList;
            ArrayList<MediaData> arrayList2 = new ArrayList<>();
            MediaData mediaData = new MediaData();
            arrayList2.add(mediaData);
            originalThreadInfo2.f29828h = arrayList2;
            originalThreadInfo2.r = threadData.getThreadVideoInfo();
            if (threadData.isLinkThread() && threadData.getLinkThreadData() != null) {
                q0 linkThreadData = threadData.getLinkThreadData();
                originalThreadInfo2.f29827g = linkThreadData.d();
                abstractData.text = linkThreadData.a();
                mediaData.setPic(linkThreadData.b());
            } else if (threadData.isInterviewLiveStyle() && threadData.getTaskInfoData() != null) {
                mediaData.setPic(threadData.getTaskInfoData().i());
            } else if (ListUtils.getCount(threadData.getMedias()) > 0) {
                originalThreadInfo2.f29828h = threadData.getMedias();
            } else if (threadData.getThreadVideoInfo() != null && !StringUtils.isNull(threadData.getThreadVideoInfo().thumbnail_url)) {
                mediaData.setPic(threadData.getThreadVideoInfo().thumbnail_url);
            }
            originalThreadInfo2.j = threadData.getThreadAlaInfo();
            originalThreadInfo2.r();
            originalThreadInfo2.D = threadData.itemData;
            originalThreadInfo2.F = threadData.itemStarData;
            originalThreadInfo2.p = threadData.getBaijiahaoData();
            originalThreadInfo2.G = threadData.getPollData();
            return originalThreadInfo2;
        }
        return (OriginalThreadInfo) invokeL.objValue;
    }

    public ThreadData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ThreadData threadData = new ThreadData();
            threadData.setTitle(this.f29827g);
            if (this.f29828h != null) {
                threadData.setMedias(new ArrayList<>(this.f29828h));
            }
            threadData.setForum_name(this.f29824d);
            threadData.setTid(this.f29826f);
            threadData.setThreadAlaInfo(this.j);
            threadData.setFid(this.f29825e);
            threadData.setThreadType(this.k);
            threadData.isShareThread = true;
            threadData.setBaijiahaoData(this.p);
            threadData.setVideoInfo(this.r);
            threadData.setArticeCover(this.f29823c);
            threadData.originalThreadData = this;
            return threadData;
        }
        return (ThreadData) invokeV.objValue;
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
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.s.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && k() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = a.d(pbContent.text);
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
            if (!StringUtils.isNull(this.f29827g)) {
                str = this.f29827g;
            } else {
                str = (ListUtils.getItem(this.i, 0) == null || StringUtils.isNull(((AbstractData) ListUtils.getItem(this.i, 0)).text)) ? null : ((AbstractData) ListUtils.getItem(this.i, 0)).text;
            }
            return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0efe) : str;
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
    public List<c> f() {
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
            int i = baijiahaoData.oriUgcType;
            return i == 1 || i == 2 || i == 3 || i == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.k;
            return i == 40 || i == 50;
        }
        return invokeV.booleanValue;
    }

    public void m(OriginThreadInfo originThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, originThreadInfo) == null) {
            n(originThreadInfo, null);
        }
    }

    public void n(OriginThreadInfo originThreadInfo, @Nullable ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, originThreadInfo, threadData) == null) {
            if (originThreadInfo == null) {
                q();
                return;
            }
            s(threadData);
            this.f29824d = originThreadInfo.fname;
            this.f29825e = originThreadInfo.fid.longValue();
            this.f29826f = originThreadInfo.tid;
            this.f29827g = originThreadInfo.title;
            this.k = originThreadInfo.thread_type.intValue();
            this.s = originThreadInfo.content;
            this.y = originThreadInfo.author;
            this.z = originThreadInfo.agree;
            this.A = originThreadInfo.reply_num;
            this.B = originThreadInfo.shared_num;
            if (!ListUtils.isEmpty(originThreadInfo.media)) {
                this.f29828h = new ArrayList<>();
                for (Media media : originThreadInfo.media) {
                    if (media != null) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(media);
                        this.f29828h.add(mediaData);
                    }
                }
            } else {
                this.f29828h = null;
            }
            if (!ListUtils.isEmpty(originThreadInfo._abstract)) {
                this.i = new ArrayList();
                for (Abstract r1 : originThreadInfo._abstract) {
                    if (r1 != null) {
                        AbstractData abstractData = new AbstractData();
                        abstractData.parser(r1);
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
            this.x = originThreadInfo.is_new_style.intValue() == 1;
            if (originThreadInfo.voice_info != null) {
                this.q = new ArrayList<>();
                for (int i = 0; i < originThreadInfo.voice_info.size(); i++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(originThreadInfo.voice_info.get(i));
                    this.q.add(voiceModel);
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
                this.f29824d = jSONObject.optString("fname");
                this.f29825e = jSONObject.optLong("fid", 0L);
                this.f29826f = jSONObject.optString("tid");
                this.f29827g = jSONObject.optString("title");
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
                    this.f29828h = new ArrayList<>();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray.getJSONObject(i));
                        this.f29828h.add(mediaData);
                    }
                } else {
                    this.f29828h = null;
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
                this.x = z;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("ori_ugc_info");
                if (optJSONObject2 != null) {
                    BaijiahaoData baijiahaoData = new BaijiahaoData();
                    this.p = baijiahaoData;
                    baijiahaoData.parseJson(optJSONObject2);
                }
                this.r = h2.a(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    this.q = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        voiceModel.parseJson(optJSONArray3.optJSONObject(i3));
                        this.q.add(voiceModel);
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
            this.f29822b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cea);
            this.f29823c = null;
        }
    }

    public void r() {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.k;
            if (i == 40) {
                this.a = 3;
            } else if (i == 54) {
                this.a = 2;
            } else if (i != 60 && i != 69 && i != 49 && i != 50) {
                this.a = 0;
            } else {
                this.a = 4;
            }
            if (ListUtils.getItem(this.f29828h, 0) != null) {
                String str = ((MediaData) ListUtils.getItem(this.f29828h, 0)).small_pic_url;
                this.f29823c = str;
                if (StringUtils.isNull(str)) {
                    this.f29823c = ((MediaData) ListUtils.getItem(this.f29828h, 0)).getPicUrl();
                }
            }
            if (StringUtils.isNull(this.f29823c) && (videoInfo = this.r) != null) {
                this.f29823c = videoInfo.thumbnail_url;
            }
            if (this.a == 0) {
                if (StringUtils.isNull(this.f29823c)) {
                    this.a = 0;
                } else {
                    this.a = 1;
                }
            }
            if (ListUtils.getItem(this.i, 0) != null && !StringUtils.isNull(((AbstractData) ListUtils.getItem(this.i, 0)).text)) {
                this.f29822b = ((AbstractData) ListUtils.getItem(this.i, 0)).text;
            } else if (!StringUtils.isNull(this.f29827g)) {
                this.f29822b = this.f29827g;
            } else {
                this.f29822b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cea);
            }
        }
    }

    public void s(@Nullable ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            this.w = threadData;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                shareInfo.threadId = originalThreadInfo.f29826f;
                shareInfo.showType = originalThreadInfo.a;
                shareInfo.showText = originalThreadInfo.f29822b;
                shareInfo.showPicUrl = originalThreadInfo.f29823c;
                shareInfo.videoId = originalThreadInfo.l;
                shareInfo.oriUgcInfo = originalThreadInfo.p;
                shareInfo.itemData = originalThreadInfo.D;
                shareInfo.itemStarData = originalThreadInfo.F;
                shareInfo.pollData = originalThreadInfo.G;
                return shareInfo;
            }
            return (ShareInfo) invokeL.objValue;
        }

        public static ShareInfo generateShareInfo(ThreadData threadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) ? generateShareInfo(OriginalThreadInfo.l(threadData)) : (ShareInfo) invokeL.objValue;
        }
    }
}
