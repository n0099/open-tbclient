package c.a.p0.f1.t2;

import android.animation.ValueAnimator;
import android.view.View;
import c.a.p0.f1.j1.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f1.j1.g f14665b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.c3.c f14666c;

    /* renamed from: d  reason: collision with root package name */
    public View f14667d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f14668e;

    public d() {
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

    public final void a(c.a.p0.f1.j1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f14135b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f14136c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f14140g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f14139f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f14137d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f14138e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f14141h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f14141h.f14145e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f14141h.f14146f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f14141h.f14142b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f14141h.f14143c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f14141h.f14144d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.u = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f14148c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f14149d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f14150e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f14151f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f14152g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f14153h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.f14127f = videoSerializeVideoThreadInfo.playCount;
        }
        gVar.v = cVar;
        if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid;
            baijiahaoData.oriUgcTid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcTid;
            baijiahaoData.oriUgcType = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcType;
            baijiahaoData.oriUgcVid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcVid;
            baijiahaoData.forwardUrl = videoSerializeVideoThreadInfo.getBaijiahaoData().forwardUrl;
            gVar.w = baijiahaoData;
        }
        gVar.a = videoSerializeVideoThreadInfo.forumId;
        gVar.f14123b = videoSerializeVideoThreadInfo.threadId;
        gVar.f14125d = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f14126e = videoSerializeVideoThreadInfo.createTime;
        gVar.f14128g = videoSerializeVideoThreadInfo.postNum;
        gVar.i = videoSerializeVideoThreadInfo.agreeNum;
        gVar.j = videoSerializeVideoThreadInfo.disAgreeNum;
        gVar.k = videoSerializeVideoThreadInfo.agreeType;
        gVar.l = videoSerializeVideoThreadInfo.hasAgree;
        if (gVar.getAgreeData() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
            gVar.getAgreeData().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
            gVar.getAgreeData().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
            gVar.getAgreeData().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
            gVar.getAgreeData().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
            gVar.getAgreeData().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
            gVar.getAgreeData().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
        }
        gVar.f14129h = videoSerializeVideoThreadInfo.shareNum;
        gVar.t = videoSerializeVideoThreadInfo.title;
        gVar.m = videoSerializeVideoThreadInfo.source;
        gVar.o = videoSerializeVideoThreadInfo.extra;
        gVar.p = videoSerializeVideoThreadInfo.ab_tag;
        gVar.n = videoSerializeVideoThreadInfo.weight;
        gVar.A = videoSerializeVideoThreadInfo.mWorksInfoData;
    }

    public c.a.p0.f1.j1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f14665b == null) {
                this.f14665b = new c.a.p0.f1.j1.g();
            }
            a(this.f14665b, this.a.e());
            return this.f14665b;
        }
        return (c.a.p0.f1.j1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f14668e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f14668e = null;
            }
            View view = this.f14667d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        c.a.p0.c3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f14666c) == null) {
            return;
        }
        cVar.v0();
        this.f14666c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.a = iVar;
        }
    }
}
