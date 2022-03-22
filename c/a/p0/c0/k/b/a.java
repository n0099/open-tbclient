package c.a.p0.c0.k.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.p0.c0.k.d.c;
import c.a.p0.h0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f13243b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadUserInfoLayout f13244c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13245d;

    /* renamed from: e  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f13246e;

    /* renamed from: f  reason: collision with root package name */
    public View f13247f;

    /* renamed from: g  reason: collision with root package name */
    public AlaVideoContainer f13248g;

    /* renamed from: h  reason: collision with root package name */
    public View f13249h;
    public ThreadData i;
    public String j;
    public c k;
    public final View.OnClickListener l;

    /* renamed from: c.a.p0.c0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0995a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0995a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.k == null) {
                return;
            }
            this.a.k.b(view, this.a.i);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new View$OnClickListenerC0995a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0301, (ViewGroup) null);
        this.a = inflate;
        this.f13243b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0911f5);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0904fc);
        this.f13244c = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f13245d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091f51);
        this.f13248g = (AlaVideoContainer) this.a.findViewById(R.id.obfuscated_res_0x7f090227);
        this.f13247f = this.a.findViewById(R.id.obfuscated_res_0x7f0907e8);
        this.f13246e = (ThreadCommentAndPraiseInfoLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091f2a);
        this.f13249h = this.a.findViewById(R.id.obfuscated_res_0x7f0907f4);
        this.f13243b.setOnClickListener(this);
        this.f13246e.setOnClickListener(this);
        this.f13246e.getCommentContainer().setOnClickListener(this);
        this.f13248g.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final void d(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            this.f13246e.onChangeSkinType();
            this.f13244c.h();
            this.f13248g.o(TbadkCoreApplication.getInst().getSkinType());
            this.f13243b.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.f13249h, R.color.CAM_X0204);
            if (threadData != null && m.k(threadData.getId())) {
                SkinManager.setViewTextColor(this.f13245d, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f13245d, (int) R.color.CAM_X0105);
            }
        }
    }

    public void e() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (threadData = this.i) == null || threadData.getAuthor() == null) {
            return;
        }
        f(this.i, this.j);
    }

    public void f(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, threadData, str) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        this.i = threadData;
        this.j = str;
        this.f13243b.setVisibility(0);
        this.f13244c.j(threadData);
        if (this.f13244c.getHeaderImg() != null) {
            this.f13244c.getHeaderImg().setData(threadData);
        }
        this.f13244c.setUserAfterClickListener(this.l);
        threadData.parserSpecTitleForFrsAndPb(false, true);
        this.f13245d.setText(threadData.getSpan_str());
        this.f13248g.getController().d(threadData, str, "", false);
        this.f13248g.getController().c();
        this.f13246e.setReplyTimeVisible(false);
        this.f13246e.setNeedAddReplyIcon(true);
        this.f13246e.setIsBarViewVisible(false);
        this.f13246e.setCommentNumEnable(false);
        this.f13246e.setOnClickListener(this);
        this.f13246e.setLiveShareEnable(false);
        this.f13246e.setShareVisible(true);
        this.f13246e.setShowPraiseNum(true);
        this.f13246e.setNeedAddPraiseIcon(true);
        this.f13246e.setFrom(2);
        if (this.f13246e.setData(threadData)) {
            this.f13247f.setVisibility(8);
        } else {
            this.f13247f.setVisibility(0);
        }
        d(threadData);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f13246e == null || (threadUserInfoLayout = this.f13244c) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.k = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view != this.f13243b && view != this.f13246e.getCommentContainer()) {
                if (view.getId() != R.id.obfuscated_res_0x7f09231b || (cVar = this.k) == null) {
                    return;
                }
                cVar.a(view, this.i);
                return;
            }
            ThreadData threadData = this.i;
            if (threadData != null) {
                m.a(threadData.getId());
            }
            c cVar2 = this.k;
            if (cVar2 != null) {
                cVar2.a(view, this.i);
            }
        }
    }
}
