package c.a.r0.x0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import c.a.r0.x0.h1.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f27721a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.x0.h1.g f27722b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.q2.c f27723c;

    /* renamed from: d  reason: collision with root package name */
    public View f27724d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f27725e;

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

    public final void a(c.a.r0.x0.h1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f27010a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f27011b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f27012c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f27016g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f27015f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f27013d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f27014e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f27017h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f27017h.f27022e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f27017h.f27023f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f27017h.f27019b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f27017h.f27020c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f27017h.f27021d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f27026c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f27027d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f27028e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f27029f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f27030g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f27031h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.f27033j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.f27003j = videoSerializeVideoThreadInfo.playCount;
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
        gVar.f26998e = videoSerializeVideoThreadInfo.forumId;
        gVar.f26999f = videoSerializeVideoThreadInfo.threadId;
        gVar.f27001h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f27002i = videoSerializeVideoThreadInfo.createTime;
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

    public c.a.r0.x0.h1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f27722b == null) {
                this.f27722b = new c.a.r0.x0.h1.g();
            }
            a(this.f27722b, this.f27721a.e());
            return this.f27722b;
        }
        return (c.a.r0.x0.h1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f27725e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f27725e = null;
            }
            View view = this.f27724d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        c.a.r0.q2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f27723c) == null) {
            return;
        }
        cVar.v0();
        this.f27723c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.f27721a = iVar;
        }
    }
}
