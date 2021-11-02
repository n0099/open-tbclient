package b.a.r0.x0.z2;

import android.animation.ValueAnimator;
import android.view.View;
import b.a.r0.x0.r1.g;
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
    public i f26977a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.x0.r1.g f26978b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.q2.c f26979c;

    /* renamed from: d  reason: collision with root package name */
    public View f26980d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f26981e;

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

    public final void a(b.a.r0.x0.r1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f26266a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f26267b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f26268c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f26272g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f26271f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f26269d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f26270e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f26273h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f26273h.f26278e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f26273h.f26279f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f26273h.f26275b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f26273h.f26276c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f26273h.f26277d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f26282c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f26283d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f26284e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f26285f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f26286g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f26287h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f26255e = videoSerializeVideoThreadInfo.forumId;
        gVar.f26256f = videoSerializeVideoThreadInfo.threadId;
        gVar.f26258h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f26259i = videoSerializeVideoThreadInfo.createTime;
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

    public b.a.r0.x0.r1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f26978b == null) {
                this.f26978b = new b.a.r0.x0.r1.g();
            }
            a(this.f26978b, this.f26977a.e());
            return this.f26978b;
        }
        return (b.a.r0.x0.r1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f26981e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f26981e = null;
            }
            View view = this.f26980d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        b.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f26979c) == null) {
            return;
        }
        cVar.v0();
        this.f26979c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.f26977a = iVar;
        }
    }
}
