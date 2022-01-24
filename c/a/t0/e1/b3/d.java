package c.a.t0.e1.b3;

import android.animation.ValueAnimator;
import android.view.View;
import c.a.t0.e1.t1.g;
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
    public c.a.t0.e1.t1.g f16150b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.a3.c f16151c;

    /* renamed from: d  reason: collision with root package name */
    public View f16152d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f16153e;

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

    public final void a(c.a.t0.e1.t1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f16933b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f16934c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f16938g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f16937f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f16935d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f16936e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f16939h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f16939h.f16943e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f16939h.f16944f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f16939h.f16940b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f16939h.f16941c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f16939h.f16942d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f16946c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f16947d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f16948e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f16949f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f16950g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f16951h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.f16953j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.f16927j = videoSerializeVideoThreadInfo.playCount;
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
        gVar.f16922e = videoSerializeVideoThreadInfo.forumId;
        gVar.f16923f = videoSerializeVideoThreadInfo.threadId;
        gVar.f16925h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f16926i = videoSerializeVideoThreadInfo.createTime;
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

    public c.a.t0.e1.t1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f16150b == null) {
                this.f16150b = new c.a.t0.e1.t1.g();
            }
            a(this.f16150b, this.a.e());
            return this.f16150b;
        }
        return (c.a.t0.e1.t1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f16153e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f16153e = null;
            }
            View view = this.f16152d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        c.a.t0.a3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f16151c) == null) {
            return;
        }
        cVar.v0();
        this.f16151c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.a = iVar;
        }
    }
}
