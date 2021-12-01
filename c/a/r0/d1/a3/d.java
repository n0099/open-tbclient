package c.a.r0.d1.a3;

import android.animation.ValueAnimator;
import android.view.View;
import c.a.r0.d1.s1.g;
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
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.d1.s1.g f15185b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.x2.c f15186c;

    /* renamed from: d  reason: collision with root package name */
    public View f15187d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f15188e;

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

    public final void a(c.a.r0.d1.s1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, gVar, videoSerializeVideoThreadInfo) == null) || videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f15970b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f15971c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f15975g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f15974f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f15972d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f15973e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f15976h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f15976h.f15980e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f15976h.f15981f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f15976h.f15977b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f15976h.f15978c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f15976h.f15979d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f15983c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f15984d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f15985e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f15986f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f15987g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f15988h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.f15990j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.f15963j = videoSerializeVideoThreadInfo.playCount;
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
        gVar.f15958e = videoSerializeVideoThreadInfo.forumId;
        gVar.f15959f = videoSerializeVideoThreadInfo.threadId;
        gVar.f15961h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f15962i = videoSerializeVideoThreadInfo.createTime;
        gVar.f15964k = videoSerializeVideoThreadInfo.postNum;
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

    public c.a.r0.d1.s1.g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f15185b == null) {
                this.f15185b = new c.a.r0.d1.s1.g();
            }
            a(this.f15185b, this.a.e());
            return this.f15185b;
        }
        return (c.a.r0.d1.s1.g) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f15188e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f15188e = null;
            }
            View view = this.f15187d;
            if (view != null) {
                view.clearAnimation();
            }
            d();
        }
    }

    public void d() {
        c.a.r0.x2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f15186c) == null) {
            return;
        }
        cVar.v0();
        this.f15186c = null;
    }

    public void e(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.a = iVar;
        }
    }
}
