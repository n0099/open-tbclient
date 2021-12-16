package c.a.s0.d1.a3;

import android.animation.ValueAnimator;
import android.view.View;
import c.a.s0.d1.s1.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.d1.s1.g f15595b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.z2.c f15596c;

    /* renamed from: d  reason: collision with root package name */
    public View f15597d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f15598e;

    public d() {
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

    public final void a(c.a.s0.d1.s1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f16380b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f16381c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f16385g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f16384f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f16382d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f16383e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f16386h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f16386h.f16390e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f16386h.f16391f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f16386h.f16387b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f16386h.f16388c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f16386h.f16389d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f16393c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f16394d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f16395e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f16396f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f16397g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f16398h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.f16400j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.f16373j = videoSerializeVideoThreadInfo.playCount;
        }
        gVar.z = cVar;
        if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid;
            baijiahaoData.oriUgcTid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcTid;
            baijiahaoData.oriUgcType = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcType;
            baijiahaoData.oriUgcVid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcVid;
            baijiahaoData.forwardUrl = videoSerializeVideoThreadInfo.getBaijiahaoData().forwardUrl;
            gVar.A = baijiahaoData;
        }
        gVar.f16368e = videoSerializeVideoThreadInfo.forumId;
        gVar.f16369f = videoSerializeVideoThreadInfo.threadId;
        gVar.f16371h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f16372i = videoSerializeVideoThreadInfo.createTime;
        gVar.f16374k = videoSerializeVideoThreadInfo.postNum;
        gVar.m = videoSerializeVideoThreadInfo.agreeNum;
        gVar.n = videoSerializeVideoThreadInfo.disAgreeNum;
        gVar.o = videoSerializeVideoThreadInfo.agreeType;
        gVar.p = videoSerializeVideoThreadInfo.hasAgree;
        if (gVar.i() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
            gVar.i().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
            gVar.i().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
            gVar.i().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
            gVar.i().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
            gVar.i().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
            gVar.i().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
        }
        gVar.l = videoSerializeVideoThreadInfo.shareNum;
        gVar.x = videoSerializeVideoThreadInfo.title;
        gVar.q = videoSerializeVideoThreadInfo.source;
        gVar.s = videoSerializeVideoThreadInfo.extra;
        gVar.t = videoSerializeVideoThreadInfo.ab_tag;
        gVar.r = videoSerializeVideoThreadInfo.weight;
        gVar.E = videoSerializeVideoThreadInfo.mWorksInfoData;
    }

    public c.a.s0.d1.s1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f15595b == null) {
                this.f15595b = new c.a.s0.d1.s1.g();
            }
            a(this.f15595b, this.a.e());
            return this.f15595b;
        }
        return (c.a.s0.d1.s1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f15598e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f15598e = null;
            }
            View view = this.f15597d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        c.a.s0.z2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f15596c) == null) {
            return;
        }
        cVar.v0();
        this.f15596c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.a = iVar;
        }
    }
}
