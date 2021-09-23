package c.a.r0.k1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f21674b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21675c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21676d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21677e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21678f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21679g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f21680h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f21681i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21682e;

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
            this.f21682e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21682e.f21680h.onItemViewClick(this.f21682e.f21679g, 100, 0, 0L, this.f21682e.f21681i);
            }
        }
    }

    /* renamed from: c.a.r0.k1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1013b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21683e;

        public View$OnClickListenerC1013b(b bVar) {
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
            this.f21683e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21683e.f21680h.onItemViewClick(this.f21683e.f21675c, 101, 0, 0L, this.f21683e.f21681i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21684e;

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
            this.f21684e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21684e.f21680h.onItemViewLongClick(this.f21684e.f21674b, 200, 0, 0L, this.f21684e.f21681i);
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
        this.f21680h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1976a.findViewById(R.id.root_view);
            this.f21674b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f21675c = headImageView;
            headImageView.setIsRound(false);
            this.f21676d = (TextView) this.f21674b.findViewById(R.id.tv_user_name);
            this.f21677e = (TextView) this.f21674b.findViewById(R.id.tv_group_name);
            this.f21678f = (TextView) this.f21674b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f21674b.findViewById(R.id.btn_pass);
            this.f21679g = textView;
            textView.setOnClickListener(new a(this));
            this.f21675c.setOnClickListener(new View$OnClickListenerC1013b(this));
            this.f21674b.setOnLongClickListener(new c(this));
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
            this.f21681i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f21681i == null) {
            return;
        }
        this.f21680h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f21680h.getLayoutMode().j(this.f21674b);
        String portrait = this.f21681i.getPortrait();
        this.f21675c.setTag(portrait);
        this.f21675c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f21681i.getUserName())) {
            this.f21676d.setText(this.f21681i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f21681i.getGroupName())) {
            TextView textView = this.f21677e;
            textView.setText(this.f21680h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f21681i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f21681i.getApplyReason())) {
            TextView textView2 = this.f21678f;
            textView2.setText(this.f21680h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f21681i.getApplyReason());
        }
        if (this.f21681i.isPass()) {
            this.f21679g.setEnabled(false);
            this.f21679g.setText(this.f21680h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f21679g, R.color.CAM_X0109);
            this.f21679g.setBackgroundDrawable(null);
        } else {
            this.f21679g.setEnabled(true);
            this.f21679g.setText(this.f21680h.getPageContext().getString(R.string.pass));
        }
        if (this.f21681i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f21674b, R.color.common_color_10178);
    }
}
