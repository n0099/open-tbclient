package b.a.r0.x0.a3;

import android.animation.ValueAnimator;
import android.view.View;
import b.a.r0.x0.s1.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f26991a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.x0.s1.g f26992b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.q2.c f26993c;

    /* renamed from: d  reason: collision with root package name */
    public View f26994d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f26995e;

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

    public final void a(b.a.r0.x0.s1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f27863a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f27864b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f27865c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f27869g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f27868f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f27866d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f27867e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f27870h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f27870h.f27875e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f27870h.f27876f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f27870h.f27872b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f27870h.f27873c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f27870h.f27874d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f27879c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f27880d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f27881e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f27882f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f27883g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f27884h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.j = videoSerializeVideoThreadInfo.playCount;
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
        gVar.f27852e = videoSerializeVideoThreadInfo.forumId;
        gVar.f27853f = videoSerializeVideoThreadInfo.threadId;
        gVar.f27855h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f27856i = videoSerializeVideoThreadInfo.createTime;
        gVar.k = videoSerializeVideoThreadInfo.postNum;
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

    public b.a.r0.x0.s1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f26992b == null) {
                this.f26992b = new b.a.r0.x0.s1.g();
            }
            a(this.f26992b, this.f26991a.e());
            return this.f26992b;
        }
        return (b.a.r0.x0.s1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f26995e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f26995e = null;
            }
            View view = this.f26994d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        b.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f26993c) == null) {
            return;
        }
        cVar.v0();
        this.f26993c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.f26991a = iVar;
        }
    }
}
