package c.a.r0.q1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.k3.w;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f23691a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f23692b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23693c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f23694d;

    /* renamed from: e  reason: collision with root package name */
    public final View f23695e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f23696f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f23697g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f23698h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f23699i;

    /* renamed from: j  reason: collision with root package name */
    public final List<TbImageView> f23700j;
    public LegoListActivity k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f23701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f23702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f23703g;

        public a(j jVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23703g = jVar;
            this.f23701e = str;
            this.f23702f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23703g.f(this.f23701e, this.f23702f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f23704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f23705f;

        public b(j jVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23705f = jVar;
            this.f23704e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23705f.e(this.f23704e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f23706e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f23707f;

        public c(j jVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23707f = jVar;
            this.f23706e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                w.c(this.f23707f.k.getPageContext(), this.f23706e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.q1.p.d f23708e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f23709f;

        public d(j jVar, c.a.r0.q1.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23709f = jVar;
            this.f23708e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23709f.h(this.f23708e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f23710e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f23711f;

        public e(j jVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23711f = jVar;
            this.f23710e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f23710e.t);
                c.a.e.e.p.l.M(this.f23711f.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    public j(LegoListActivity legoListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {legoListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f23691a = navigationBar;
        this.f23695e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f23692b = (RelativeLayout) this.f23691a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f23691a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f23693c = (TextView) this.f23692b.findViewById(R.id.lego_title);
        this.f23694d = (TbImageView) this.f23692b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f23692b.findViewById(R.id.ll_right);
        this.f23696f = linearLayout;
        this.f23697g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f23698h = (TbImageView) this.f23696f.findViewById(R.id.iv2);
        this.f23699i = (TbImageView) this.f23696f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.f23700j = arrayList;
        arrayList.add(this.f23697g);
        this.f23700j.add(this.f23698h);
        this.f23700j.add(this.f23699i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23691a.setVisibility(8);
        }
    }

    public final void e(List<c.a.r0.q1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f23696f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.f23700j.size(); i2++) {
            this.f23700j.get(i2).setVisibility(0);
            if (list.get(i2).f23848d == 2) {
                SkinManager.setImageResource(this.f23700j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f23700j.get(i2).startLoad(list.get(i2).f23846b, 10, false);
            } else {
                this.f23700j.get(i2).startLoad(list.get(i2).f23845a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f23847c)) {
                String str = list.get(i2).f23847c;
                if (list.get(i2).f23848d == 1) {
                    this.f23700j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f23848d == 2) {
                    this.f23700j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.f23700j.size(); size++) {
            this.f23700j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f23694d) == null || this.f23693c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f23693c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f23694d.startLoad(str2, 10, false);
        } else {
            this.f23694d.startLoad(str, 10, false);
        }
    }

    public void g(List<c.a.r0.q1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f23696f.setVisibility(8);
                return;
            }
            e(list);
            this.f23696f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(c.a.r0.q1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f23848d == 2) {
            String str = dVar.f23851g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f23849e;
            shareItem.s = dVar.f23850f;
            shareItem.t = dVar.f23847c;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new e(this, shareItem));
            this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SkinManager.setViewTextColor(this.f23693c, R.color.CAM_X0105);
            this.f23693c.setVisibility(0);
            this.f23694d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f23693c.setText(str);
            } else {
                this.f23693c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f23694d.postDelayed(new a(this, str, str2), 1000L);
    }
}
