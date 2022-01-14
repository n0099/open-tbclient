package c.a.t0.s1.x;

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
/* loaded from: classes8.dex */
public class b extends c.a.d.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f22277b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f22278c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22279d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22280e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22281f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22282g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f22283h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f22284i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22285e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22285e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22285e.f22283h.onItemViewClick(this.f22285e.f22282g, 100, 0, 0L, this.f22285e.f22284i);
            }
        }
    }

    /* renamed from: c.a.t0.s1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1381b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22286e;

        public View$OnClickListenerC1381b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22286e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22286e.f22283h.onItemViewClick(this.f22286e.f22278c, 101, 0, 0L, this.f22286e.f22284i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22287e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22287e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f22287e.f22283h.onItemViewLongClick(this.f22287e.f22277b, 200, 0, 0L, this.f22287e.f22284i);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22283h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f22277b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f22278c = headImageView;
            headImageView.setIsRound(false);
            this.f22279d = (TextView) this.f22277b.findViewById(R.id.tv_user_name);
            this.f22280e = (TextView) this.f22277b.findViewById(R.id.tv_group_name);
            this.f22281f = (TextView) this.f22277b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f22277b.findViewById(R.id.btn_pass);
            this.f22282g = textView;
            textView.setOnClickListener(new a(this));
            this.f22278c.setOnClickListener(new View$OnClickListenerC1381b(this));
            this.f22277b.setOnLongClickListener(new c(this));
        }
    }

    public void k(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, validateItemData) == null) {
            l(validateItemData);
            refresh();
        }
    }

    public void l(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, validateItemData) == null) {
            this.f22284i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f22284i == null) {
            return;
        }
        this.f22283h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f22283h.getLayoutMode().j(this.f22277b);
        String portrait = this.f22284i.getPortrait();
        this.f22278c.setTag(portrait);
        this.f22278c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f22284i.getUserName())) {
            this.f22279d.setText(this.f22284i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f22284i.getGroupName())) {
            TextView textView = this.f22280e;
            textView.setText(this.f22283h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f22284i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f22284i.getApplyReason())) {
            TextView textView2 = this.f22281f;
            textView2.setText(this.f22283h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f22284i.getApplyReason());
        }
        if (this.f22284i.isPass()) {
            this.f22282g.setEnabled(false);
            this.f22282g.setText(this.f22283h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f22282g, R.color.CAM_X0109);
            this.f22282g.setBackgroundDrawable(null);
        } else {
            this.f22282g.setEnabled(true);
            this.f22282g.setText(this.f22283h.getPageContext().getString(R.string.pass));
        }
        if (this.f22284i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f22277b, R.color.common_color_10178);
    }
}
