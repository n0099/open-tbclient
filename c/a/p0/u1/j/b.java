package c.a.p0.u1.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes2.dex */
public class b extends c.a.d.a.c<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f18811b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f18812c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18813d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18814e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18815f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18816g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f18817h;
    public RelativeLayout i;
    public RelativeLayout j;
    public UpdatesActivity k;
    public UpdatesItemData l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* renamed from: c.a.p0.u1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1414b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC1414b(b bVar) {
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
                if (this.a.k.isEditMode()) {
                    this.a.f18817h.performClick();
                } else {
                    this.a.k.onItemViewClick(this.a.f18811b, 101, 0, 0L, this.a.l);
                }
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
                this.a.k.onItemViewLongClick(this.a.f18811b, 200, 0, 0L, this.a.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
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
                this.a.k.onItemViewClick(this.a.f18811b, 101, 0, 0L, this.a.l);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
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
                this.a.k.onItemViewLongClick(this.a.f18811b, 200, 0, 0L, this.a.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public f(b bVar) {
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
                view.setSelected(!view.isSelected());
                this.a.k.onCheckedChanged(view, view.isSelected(), this.a.l);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.obfuscated_res_0x7f0d0861);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.d.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = updatesActivity;
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091aee);
            this.f18811b = findViewById;
            this.f18812c = (HeadImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f090fd6);
            this.f18813d = (TextView) this.f18811b.findViewById(R.id.obfuscated_res_0x7f0921bc);
            this.f18814e = (TextView) this.f18811b.findViewById(R.id.obfuscated_res_0x7f092198);
            this.f18815f = (TextView) this.f18811b.findViewById(R.id.obfuscated_res_0x7f09221e);
            this.f18816g = (TextView) this.f18811b.findViewById(R.id.obfuscated_res_0x7f09221b);
            this.f18817h = (ImageView) this.f18811b.findViewById(R.id.obfuscated_res_0x7f0905a6);
            this.i = (RelativeLayout) this.f18811b.findViewById(R.id.obfuscated_res_0x7f0911c5);
            this.j = (RelativeLayout) this.f18811b.findViewById(R.id.obfuscated_res_0x7f0911fc);
            this.f18812c.setOnClickListener(new a(this));
            this.i.setClickable(true);
            this.i.setLongClickable(true);
            this.j.setClickable(true);
            this.j.setLongClickable(true);
            this.i.setOnClickListener(new View$OnClickListenerC1414b(this));
            this.i.setOnLongClickListener(new c(this));
            this.j.setOnClickListener(new d(this));
            this.j.setOnLongClickListener(new e(this));
            this.f18817h.setOnClickListener(new f(this));
        }
    }

    public void l(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, updatesItemData) == null) {
            m(updatesItemData);
            refresh();
        }
    }

    public void m(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, updatesItemData) == null) {
            this.l = updatesItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.l == null) {
            return;
        }
        if (this.k.isEditMode()) {
            this.f18817h.setVisibility(0);
        } else {
            this.f18817h.setVisibility(8);
            this.i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f18812c.setTag(groupHeadUrl);
            this.f18812c.J(groupHeadUrl, 10, false);
        } else {
            this.f18812c.setTag(null);
        }
        this.f18812c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f18815f.setText(this.l.getTitle());
        } else {
            this.f18815f.setText(this.k.getPageContext().getString(R.string.obfuscated_res_0x7f0f08db));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f18816g.setText(StringHelper.getPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f18814e.setText(this.l.getContent());
        } else {
            this.f18814e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f18813d.setText(this.l.getGroupName());
        } else {
            this.f18813d.setText("");
        }
        int paddingLeft = this.i.getPaddingLeft();
        int paddingTop = this.i.getPaddingTop();
        int paddingRight = this.i.getPaddingRight();
        int paddingBottom = this.i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.a);
        this.f18817h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
