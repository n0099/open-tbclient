package c.a.q0.v0.o2;

import android.animation.ValueAnimator;
import android.view.View;
import c.a.q0.v0.h1.g;
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
    public i f26859a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.v0.h1.g f26860b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.o2.c f26861c;

    /* renamed from: d  reason: collision with root package name */
    public View f26862d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f26863e;

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

    public final void a(c.a.q0.v0.h1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f26171a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f26172b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f26173c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f26177g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f26176f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f26174d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f26175e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f26178h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f26178h.f26183e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f26178h.f26184f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f26178h.f26180b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f26178h.f26181c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f26178h.f26182d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f26187c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f26188d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f26189e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f26190f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f26191g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f26192h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.f26194j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.f26164j = videoSerializeVideoThreadInfo.playCount;
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
        gVar.f26159e = videoSerializeVideoThreadInfo.forumId;
        gVar.f26160f = videoSerializeVideoThreadInfo.threadId;
        gVar.f26162h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f26163i = videoSerializeVideoThreadInfo.createTime;
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

    public c.a.q0.v0.h1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f26860b == null) {
                this.f26860b = new c.a.q0.v0.h1.g();
            }
            a(this.f26860b, this.f26859a.e());
            return this.f26860b;
        }
        return (c.a.q0.v0.h1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f26863e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f26863e = null;
            }
            View view = this.f26862d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        c.a.q0.o2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f26861c) == null) {
            return;
        }
        cVar.v0();
        this.f26861c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.f26859a = iVar;
        }
    }
}
