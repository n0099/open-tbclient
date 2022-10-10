package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.hv4;
import com.baidu.tieba.wx;
import com.baidu.tieba.yq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RichTextLayout extends LinearLayout implements wx<yq4>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public TextView b;
    public TextView c;
    public Context d;
    public boolean e;
    public View.OnClickListener f;
    public boolean g;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichTextLayout a;

        public a(RichTextLayout richTextLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richTextLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null) {
                return;
            }
            this.a.f.onClick(view2);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RichTextLayout a;

        public b(RichTextLayout richTextLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = richTextLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null) {
                return;
            }
            this.a.f.onClick(view2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ej.k(TbadkCoreApplication.getInst()) - ((ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.e = false;
        this.g = false;
        this.d = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0788, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092174);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092182);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wx
    /* renamed from: d */
    public void a(yq4 yq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yq4Var) == null) || yq4Var == null || yq4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = yq4Var.getThreadData();
        OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
        if (originalThreadInfo != null && this.e) {
            this.b.setVisibility(8);
            hv4 d = hv4.d(this.c);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X07);
            if (!originalThreadInfo.m && !yq4Var.getThreadData().shouldShowBlockedState()) {
                SpannableString c = originalThreadInfo.c();
                ThreadCardUtils.setAbstract(this.c, this.b, c, threadData, this.a, this.e, this.g);
                if (c != null) {
                    TiePlusEventController.o(originalThreadInfo.h());
                }
            } else {
                ThreadCardUtils.setAbstract(this.c, this.b, new SpannableString(this.d.getString(R.string.obfuscated_res_0x7f0f0d2b)), threadData, this.a, this.e, this.g);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
            }
        } else {
            ThreadCardUtils.setTitle(this.b, threadData, this.g);
            SpannableString abstractText = threadData.getAbstractText();
            ThreadCardUtils.setAbstract(this.c, this.b, abstractText, threadData, this.a, this.e, this.g);
            if (abstractText != null) {
                TiePlusEventController.o(threadData.getTiePlusLinkOriginData());
            }
        }
        if (!this.e) {
            this.c.setClickable(false);
            this.b.setClickable(false);
        } else if (originalThreadInfo != null && (originalThreadInfo.m || threadData.shouldShowBlockedState())) {
            setOnClickListener(null);
            setClickable(true);
        } else {
            setOnClickListener(this);
            this.c.setOnClickListener(new a(this));
            this.b.setOnClickListener(new b(this));
            this.c.setClickable(true);
            this.b.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (onClickListener = this.f) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.g = z;
        }
    }

    public void setTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e = z;
        }
    }
}
