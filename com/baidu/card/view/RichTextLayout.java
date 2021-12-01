package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.k.p;
import c.a.q0.s.q.d2;
import c.a.q0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RichTextLayout extends LinearLayout implements p<c.a.q0.s.q.a>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f33742e;

    /* renamed from: f  reason: collision with root package name */
    public Context f33743f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33744g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f33745h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33746i;
    public TextView mAbstract;
    public TextView mTitle;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RichTextLayout f33747e;

        public a(RichTextLayout richTextLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33747e = richTextLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f33747e.f33745h == null) {
                return;
            }
            this.f33747e.f33745h.onClick(view);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RichTextLayout f33748e;

        public b(RichTextLayout richTextLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33748e = richTextLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f33748e.f33745h == null) {
                return;
            }
            this.f33748e.f33745h.onClick(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33742e = l.k(TbadkCoreApplication.getInst()) - ((l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.f33744g = false;
        this.f33746i = false;
        this.f33743f = context;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (onClickListener = this.f33745h) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f33745h = onClickListener;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f33746i = z;
        }
    }

    public void setTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f33744g = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.k.p
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar.getThreadData();
        OriginalThreadInfo originalThreadInfo = threadData.A1;
        if (originalThreadInfo != null && this.f33744g) {
            this.mTitle.setVisibility(8);
            c d2 = c.d(this.mAbstract);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            if (!originalThreadInfo.m && !aVar.getThreadData().P4()) {
                SpannableString b2 = originalThreadInfo.b();
                ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, b2, threadData, this.f33742e, this.f33744g, this.f33746i);
                if (b2 != null) {
                    TiePlusEventController.tryExposeTiePlusLinkEvent(originalThreadInfo.e());
                }
            } else {
                ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, new SpannableString(this.f33743f.getString(R.string.origin_thread_deleted_title)), threadData, this.f33742e, this.f33744g, this.f33746i);
                SkinManager.setViewTextColor(this.mAbstract, R.color.CAM_X0108);
            }
        } else {
            ThreadCardUtils.setTitle(this.mTitle, threadData, this.f33746i);
            SpannableString p = threadData.p();
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, p, threadData, this.f33742e, this.f33744g, this.f33746i);
            if (p != null) {
                TiePlusEventController.tryExposeTiePlusLinkEvent(threadData.w1());
            }
        }
        if (!this.f33744g) {
            this.mAbstract.setClickable(false);
            this.mTitle.setClickable(false);
        } else if (originalThreadInfo != null && (originalThreadInfo.m || threadData.P4())) {
            setOnClickListener(null);
            setClickable(true);
        } else {
            setOnClickListener(this);
            this.mAbstract.setOnClickListener(new a(this));
            this.mTitle.setOnClickListener(new b(this));
            this.mAbstract.setClickable(true);
            this.mTitle.setClickable(true);
        }
    }
}
