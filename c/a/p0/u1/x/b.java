package c.a.p0.u1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.d.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.d.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f18936b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f18937c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18938d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18939e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18940f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18941g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f18942h;
    public ValidateItemData i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f18942h.onItemViewClick(this.a.f18941g, 100, 0, 0L, this.a.i);
            }
        }
    }

    /* renamed from: c.a.p0.u1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1429b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC1429b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f18942h.onItemViewClick(this.a.f18937c, 101, 0, 0L, this.a.i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.a.f18942h.onItemViewLongClick(this.a.f18936b, 200, 0, 0L, this.a.i);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.obfuscated_res_0x7f0d086b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18942h = validateActivity;
        l();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091aee);
            this.f18936b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f090fd6);
            this.f18937c = headImageView;
            headImageView.setIsRound(false);
            this.f18938d = (TextView) this.f18936b.findViewById(R.id.obfuscated_res_0x7f092229);
            this.f18939e = (TextView) this.f18936b.findViewById(R.id.obfuscated_res_0x7f0921bc);
            this.f18940f = (TextView) this.f18936b.findViewById(R.id.obfuscated_res_0x7f092187);
            TextView textView = (TextView) this.f18936b.findViewById(R.id.obfuscated_res_0x7f09042a);
            this.f18941g = textView;
            textView.setOnClickListener(new a(this));
            this.f18937c.setOnClickListener(new View$OnClickListenerC1429b(this));
            this.f18936b.setOnLongClickListener(new c(this));
        }
    }

    public void m(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, validateItemData) == null) {
            n(validateItemData);
            refresh();
        }
    }

    public void n(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, validateItemData) == null) {
            this.i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.i == null) {
            return;
        }
        this.f18942h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f18942h.getLayoutMode().j(this.f18936b);
        String portrait = this.i.getPortrait();
        this.f18937c.setTag(portrait);
        this.f18937c.J(portrait, 12, false);
        if (!TextUtils.isEmpty(this.i.getUserName())) {
            this.f18938d.setText(this.i.getUserName());
        }
        if (!TextUtils.isEmpty(this.i.getGroupName())) {
            TextView textView = this.f18939e;
            textView.setText(this.f18942h.getPageContext().getString(R.string.obfuscated_res_0x7f0f14b2) + this.i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.i.getApplyReason())) {
            TextView textView2 = this.f18940f;
            textView2.setText(this.f18942h.getPageContext().getString(R.string.obfuscated_res_0x7f0f14b4) + this.i.getApplyReason());
        }
        if (this.i.isPass()) {
            this.f18941g.setEnabled(false);
            this.f18941g.setText(this.f18942h.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d38));
            SkinManager.setViewTextColor(this.f18941g, (int) R.color.CAM_X0109);
            this.f18941g.setBackgroundDrawable(null);
        } else {
            this.f18941g.setEnabled(true);
            this.f18941g.setText(this.f18942h.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d07));
        }
        if (this.i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f18936b, R.color.common_color_10178);
    }
}
