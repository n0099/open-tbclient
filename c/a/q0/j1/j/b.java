package c.a.q0.j1.j;

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
/* loaded from: classes3.dex */
public class b extends c.a.e.a.c<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f20859b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f20860c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20861d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20862e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20863f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20864g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f20865h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f20866i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f20867j;
    public UpdatesActivity k;
    public UpdatesItemData l;

    /* loaded from: classes3.dex */
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

    /* renamed from: c.a.q0.j1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0967b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20868e;

        public View$OnClickListenerC0967b(b bVar) {
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
            this.f20868e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20868e.k.isEditMode()) {
                    this.f20868e.f20865h.performClick();
                } else {
                    this.f20868e.k.onItemViewClick(this.f20868e.f20859b, 101, 0, 0L, this.f20868e.l);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20869e;

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
            this.f20869e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f20869e.k.onItemViewLongClick(this.f20869e.f20859b, 200, 0, 0L, this.f20869e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20870e;

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
            this.f20870e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20870e.k.onItemViewClick(this.f20870e.f20859b, 101, 0, 0L, this.f20870e.l);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20871e;

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
            this.f20871e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f20871e.k.onItemViewLongClick(this.f20871e.f20859b, 200, 0, 0L, this.f20871e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20872e;

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
            this.f20872e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setSelected(!view.isSelected());
                this.f20872e.k.onCheckedChanged(view, view.isSelected(), this.f20872e.l);
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
                super((c.a.e.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = updatesActivity;
        i();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1976a.findViewById(R.id.root_view);
            this.f20859b = findViewById;
            this.f20860c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f20861d = (TextView) this.f20859b.findViewById(R.id.tv_group_name);
            this.f20862e = (TextView) this.f20859b.findViewById(R.id.tv_content);
            this.f20863f = (TextView) this.f20859b.findViewById(R.id.tv_title);
            this.f20864g = (TextView) this.f20859b.findViewById(R.id.tv_time);
            this.f20865h = (ImageView) this.f20859b.findViewById(R.id.cb_select);
            this.f20866i = (RelativeLayout) this.f20859b.findViewById(R.id.layout_body);
            this.f20867j = (RelativeLayout) this.f20859b.findViewById(R.id.layout_title);
            this.f20860c.setOnClickListener(new a(this));
            this.f20866i.setClickable(true);
            this.f20866i.setLongClickable(true);
            this.f20867j.setClickable(true);
            this.f20867j.setLongClickable(true);
            this.f20866i.setOnClickListener(new View$OnClickListenerC0967b(this));
            this.f20866i.setOnLongClickListener(new c(this));
            this.f20867j.setOnClickListener(new d(this));
            this.f20867j.setOnLongClickListener(new e(this));
            this.f20865h.setOnClickListener(new f(this));
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
        if (this.k.isEditMode()) {
            this.f20865h.setVisibility(0);
        } else {
            this.f20865h.setVisibility(8);
            this.f20866i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f20860c.setTag(groupHeadUrl);
            this.f20860c.startLoad(groupHeadUrl, 10, false);
        } else {
            this.f20860c.setTag(null);
        }
        this.f20860c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f20863f.setText(this.l.getTitle());
        } else {
            this.f20863f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f20864g.setText(StringHelper.GetPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f20862e.setText(this.l.getContent());
        } else {
            this.f20862e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f20861d.setText(this.l.getGroupName());
        } else {
            this.f20861d.setText("");
        }
        int paddingLeft = this.f20866i.getPaddingLeft();
        int paddingTop = this.f20866i.getPaddingTop();
        int paddingRight = this.f20866i.getPaddingRight();
        int paddingBottom = this.f20866i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f1976a);
        this.f20865h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f20866i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f20866i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f20866i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
