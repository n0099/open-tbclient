package c.a.r0.r1.j;

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
/* loaded from: classes6.dex */
public class b extends c.a.d.a.c<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f23004b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f23005c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23006d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23007e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23008f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23009g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f23010h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f23011i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f23012j;

    /* renamed from: k  reason: collision with root package name */
    public UpdatesActivity f23013k;
    public UpdatesItemData l;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* renamed from: c.a.r0.r1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1324b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23014e;

        public View$OnClickListenerC1324b(b bVar) {
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
            this.f23014e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23014e.f23013k.isEditMode()) {
                    this.f23014e.f23010h.performClick();
                } else {
                    this.f23014e.f23013k.onItemViewClick(this.f23014e.f23004b, 101, 0, 0L, this.f23014e.l);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23015e;

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
            this.f23015e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f23015e.f23013k.onItemViewLongClick(this.f23015e.f23004b, 200, 0, 0L, this.f23015e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23016e;

        public d(b bVar) {
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
            this.f23016e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23016e.f23013k.onItemViewClick(this.f23016e.f23004b, 101, 0, 0L, this.f23016e.l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23017e;

        public e(b bVar) {
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
            this.f23017e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f23017e.f23013k.onItemViewLongClick(this.f23017e.f23004b, 200, 0, 0L, this.f23017e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23018e;

        public f(b bVar) {
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
            this.f23018e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setSelected(!view.isSelected());
                this.f23018e.f23013k.onCheckedChanged(view, view.isSelected(), this.f23018e.l);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.d.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23013k = updatesActivity;
        i();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f23004b = findViewById;
            this.f23005c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f23006d = (TextView) this.f23004b.findViewById(R.id.tv_group_name);
            this.f23007e = (TextView) this.f23004b.findViewById(R.id.tv_content);
            this.f23008f = (TextView) this.f23004b.findViewById(R.id.tv_title);
            this.f23009g = (TextView) this.f23004b.findViewById(R.id.tv_time);
            this.f23010h = (ImageView) this.f23004b.findViewById(R.id.cb_select);
            this.f23011i = (RelativeLayout) this.f23004b.findViewById(R.id.layout_body);
            this.f23012j = (RelativeLayout) this.f23004b.findViewById(R.id.layout_title);
            this.f23005c.setOnClickListener(new a(this));
            this.f23011i.setClickable(true);
            this.f23011i.setLongClickable(true);
            this.f23012j.setClickable(true);
            this.f23012j.setLongClickable(true);
            this.f23011i.setOnClickListener(new View$OnClickListenerC1324b(this));
            this.f23011i.setOnLongClickListener(new c(this));
            this.f23012j.setOnClickListener(new d(this));
            this.f23012j.setOnLongClickListener(new e(this));
            this.f23010h.setOnClickListener(new f(this));
        }
    }

    public void j(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, updatesItemData) == null) {
            k(updatesItemData);
            refresh();
        }
    }

    public void k(UpdatesItemData updatesItemData) {
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
        if (this.f23013k.isEditMode()) {
            this.f23010h.setVisibility(0);
        } else {
            this.f23010h.setVisibility(8);
            this.f23011i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f23005c.setTag(groupHeadUrl);
            this.f23005c.startLoad(groupHeadUrl, 10, false);
        } else {
            this.f23005c.setTag(null);
        }
        this.f23005c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f23008f.setText(this.l.getTitle());
        } else {
            this.f23008f.setText(this.f23013k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f23009g.setText(StringHelper.getPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f23007e.setText(this.l.getContent());
        } else {
            this.f23007e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f23006d.setText(this.l.getGroupName());
        } else {
            this.f23006d.setText("");
        }
        int paddingLeft = this.f23011i.getPaddingLeft();
        int paddingTop = this.f23011i.getPaddingTop();
        int paddingRight = this.f23011i.getPaddingRight();
        int paddingBottom = this.f23011i.getPaddingBottom();
        this.f23013k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f23013k.getLayoutMode().j(this.a);
        this.f23010h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.f23013k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f23011i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f23011i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f23011i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
