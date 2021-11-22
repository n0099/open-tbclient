package b.a.r0.q1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.r0.m3.w;
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
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f24104a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f24105b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f24106c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f24107d;

    /* renamed from: e  reason: collision with root package name */
    public final View f24108e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f24109f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f24110g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f24111h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f24112i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f24113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f24114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f24115g;

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
            this.f24115g = jVar;
            this.f24113e = str;
            this.f24114f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24115g.f(this.f24113e, this.f24114f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f24116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f24117f;

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
            this.f24117f = jVar;
            this.f24116e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24117f.e(this.f24116e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f24118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f24119f;

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
            this.f24119f = jVar;
            this.f24118e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                w.c(this.f24119f.k.getPageContext(), this.f24118e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.q1.p.d f24120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f24121f;

        public d(j jVar, b.a.r0.q1.p.d dVar) {
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
            this.f24121f = jVar;
            this.f24120e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24121f.h(this.f24120e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f24122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f24123f;

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
            this.f24123f = jVar;
            this.f24122e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.f.p.a.a(this.f24122e.t);
                b.a.e.f.p.l.M(this.f24123f.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
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
        this.f24104a = navigationBar;
        this.f24108e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f24105b = (RelativeLayout) this.f24104a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f24104a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f24106c = (TextView) this.f24105b.findViewById(R.id.lego_title);
        this.f24107d = (TbImageView) this.f24105b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f24105b.findViewById(R.id.ll_right);
        this.f24109f = linearLayout;
        this.f24110g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f24111h = (TbImageView) this.f24109f.findViewById(R.id.iv2);
        this.f24112i = (TbImageView) this.f24109f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f24110g);
        this.j.add(this.f24111h);
        this.j.add(this.f24112i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24104a.setVisibility(8);
        }
    }

    public final void e(List<b.a.r0.q1.p.d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f24109f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.j.size(); i2++) {
            this.j.get(i2).setVisibility(0);
            if (list.get(i2).f24254d == 2) {
                SkinManager.setImageResource(this.j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i2).startLoad(list.get(i2).f24252b, 10, false);
            } else {
                this.j.get(i2).startLoad(list.get(i2).f24251a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f24253c)) {
                String str = list.get(i2).f24253c;
                if (list.get(i2).f24254d == 1) {
                    this.j.get(i2).setOnClickListener(new c(this, str));
                } else if (list.get(i2).f24254d == 2) {
                    this.j.get(i2).setOnClickListener(new d(this, list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tbImageView = this.f24107d) == null || this.f24106c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f24106c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f24107d.startLoad(str2, 10, false);
        } else {
            this.f24107d.startLoad(str, 10, false);
        }
    }

    public void g(List<b.a.r0.q1.p.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f24109f.setVisibility(8);
                return;
            }
            e(list);
            this.f24109f.postDelayed(new b(this, list), 1000L);
        }
    }

    public void h(b.a.r0.q1.p.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && dVar.f24254d == 2) {
            String str = dVar.f24257g;
            Uri parse = str == null ? null : Uri.parse(str);
            ShareItem shareItem = new ShareItem();
            shareItem.r = dVar.f24255e;
            shareItem.s = dVar.f24256f;
            shareItem.t = dVar.f24253c;
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
            SkinManager.setViewTextColor(this.f24106c, R.color.CAM_X0105);
            this.f24106c.setVisibility(0);
            this.f24107d.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.f24106c.setText(str);
            } else {
                this.f24106c.setText("");
            }
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f24107d.postDelayed(new a(this, str, str2), 1000L);
    }
}
