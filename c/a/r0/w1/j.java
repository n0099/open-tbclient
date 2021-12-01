package c.a.r0.w1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.t3.w;
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
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f25046b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f25047c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f25048d;

    /* renamed from: e  reason: collision with root package name */
    public final View f25049e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f25050f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f25051g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f25052h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f25053i;

    /* renamed from: j  reason: collision with root package name */
    public final List<TbImageView> f25054j;

    /* renamed from: k  reason: collision with root package name */
    public LegoListActivity f25055k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25056e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f25057f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f25058g;

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
            this.f25058g = jVar;
            this.f25056e = str;
            this.f25057f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25058g.f(this.f25056e, this.f25057f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f25059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25060f;

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
            this.f25060f = jVar;
            this.f25059e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25060f.e(this.f25059e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25062f;

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
            this.f25062f = jVar;
            this.f25061e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                w.c(this.f25062f.f25055k.getPageContext(), this.f25061e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w1.p.d f25063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25064f;

        public d(j jVar, c.a.r0.w1.p.d dVar) {
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
            this.f25064f = jVar;
            this.f25063e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25064f.h(this.f25063e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f25065e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25066f;

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
            this.f25066f = jVar;
            this.f25065e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.a.a(this.f25065e.t);
                c.a.d.f.p.l.M(this.f25066f.f25055k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
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
        this.f25055k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.a = navigationBar;
        this.f25049e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f25046b = (RelativeLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f25047c = (TextView) this.f25046b.findViewById(R.id.lego_title);
        this.f25048d = (TbImageView) this.f25046b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f25046b.findViewById(R.id.ll_right);
        this.f25050f = linearLayout;
        this.f25051g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f25052h = (TbImageView) this.f25050f.findViewById(R.id.iv2);
        this.f25053i = (TbImageView) this.f25050f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.f25054j = arrayList;
        arrayList.add(this.f25051g);
        this.f25054j.add(this.f25052h);
        this.f25054j.add(this.f25053i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.setVisibility(8);
        }
    }

    public final void e(List<c.a.r0.w1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f25050f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.f25054j.size(); i2++) {
            this.f25054j.get(i2).setVisibility(0);
            if (list.get(i2).f25172d == 2) {
                SkinManager.setImageResource(this.f25054j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f25054j.get(i2).startLoad(list.get(i2).f25170b, 10, false);
            } else {
                this.f25054j.get(i2).startLoad(list.get(i2).a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f25171c)) {
                String str = list.get(i2).f25171c;
                if (list.get(i2).f25172d == 1) {
                    this.f25054j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f25172d == 2) {
                    this.f25054j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.f25054j.size(); size++) {
            this.f25054j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f25048d) == null || this.f25047c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f25047c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f25048d.startLoad(str2, 10, false);
        } else {
            this.f25048d.startLoad(str, 10, false);
        }
    }

    public void g(List<c.a.r0.w1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f25050f.setVisibility(8);
                return;
            }
            e(list);
            this.f25050f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(c.a.r0.w1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f25172d == 2) {
            String str = dVar.f25175g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f25173e;
            shareItem.s = dVar.f25174f;
            shareItem.t = dVar.f25171c;
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f25055k.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new e(this, shareItem));
            this.f25055k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SkinManager.setViewTextColor(this.f25047c, R.color.CAM_X0105);
            this.f25047c.setVisibility(0);
            this.f25048d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f25047c.setText(str);
            } else {
                this.f25047c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f25048d.postDelayed(new a(this, str, str2), 1000L);
    }
}
