package c.a.s0.w2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.personExtra.PersonFriendActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f25258e;

    /* renamed from: f  reason: collision with root package name */
    public PersonFriendActivity f25259f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25260g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f25261h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25262i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f25263j;

    /* renamed from: k  reason: collision with root package name */
    public int f25264k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25265b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25266c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f25267d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f25268e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f25269f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25270g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f25271h;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e(PersonFriendActivity personFriendActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personFriendActivity, Boolean.valueOf(z), Integer.valueOf(i2), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25258e = null;
        this.f25259f = null;
        this.f25260g = false;
        this.f25262i = false;
        this.f25263j = true;
        this.f25264k = 0;
        this.l = null;
        this.m = null;
        this.f25259f = personFriendActivity;
        this.f25261h = new ArrayList<>();
        this.f25263j = z;
        this.f25264k = i2;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f25259f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f25259f.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25262i = false;
            ArrayList<UserData> arrayList = this.f25258e;
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            this.f25262i = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f25261h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f25261h.size(); i2++) {
            try {
                this.f25261h.get(i2).setVisibility(8);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        this.f25261h.clear();
    }

    public void d(ArrayList<UserData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f25258e = arrayList;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f25260g = z;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f25262i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f25258e;
            int size = arrayList != null ? arrayList.size() : 0;
            return this.f25260g ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f25258e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f25258e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f25258e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return -1L;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f25262i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f25258e;
            return (arrayList == null || i2 >= arrayList.size()) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (this.f25258e == null) {
                return view;
            }
            if (view == null) {
                bVar = new b(this, null);
                if (getItemViewType(i2) == 0) {
                    view2 = LayoutInflater.from(this.f25259f.getPageContext().getPageActivity()).inflate(c.a.s0.y2.e.person_list_item_friend, (ViewGroup) null);
                    HeadImageView headImageView = (HeadImageView) view2.findViewById(c.a.s0.y2.d.photo);
                    bVar.a = headImageView;
                    headImageView.setIsRound(false);
                    bVar.a.setAutoChangeStyle(true);
                    bVar.f25268e = (LinearLayout) view2.findViewById(c.a.s0.y2.d.info);
                    bVar.f25265b = (TextView) view2.findViewById(c.a.s0.y2.d.name);
                    bVar.f25270g = (TextView) view2.findViewById(c.a.s0.y2.d.at_list_nodata);
                    bVar.f25266c = (TextView) view2.findViewById(c.a.s0.y2.d.intro);
                    bVar.f25267d = (ImageView) view2.findViewById(c.a.s0.y2.d.chat);
                    bVar.f25271h = (ImageView) view2.findViewById(c.a.s0.y2.d.diver_buttom_px);
                    bVar.f25267d.setOnClickListener(this.l);
                } else {
                    view2 = LayoutInflater.from(this.f25259f.getPageContext().getPageActivity()).inflate(c.a.s0.y2.e.new_pb_list_more, (ViewGroup) null);
                    bVar.f25265b = (TextView) view2.findViewById(c.a.s0.y2.d.pb_more_text);
                    view2.setOnClickListener(this.m);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(c.a.s0.y2.d.progress);
                    bVar.f25269f = progressBar;
                    this.f25261h.add(progressBar);
                }
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i2) == 0) {
                if (this.f25262i) {
                    bVar.f25268e.setVisibility(8);
                    bVar.f25267d.setVisibility(8);
                    bVar.f25270g.setVisibility(8);
                    bVar.f25271h.setVisibility(8);
                } else {
                    if (!this.f25263j && this.f25264k == 0) {
                        bVar.f25267d.setVisibility(8);
                    } else {
                        bVar.f25267d.setVisibility(0);
                    }
                    bVar.f25268e.setVisibility(0);
                    bVar.f25268e.setTag(Integer.valueOf(i2));
                    bVar.f25271h.setVisibility(0);
                    bVar.f25270g.setVisibility(8);
                    String portrait = this.f25258e.get(i2).getPortrait();
                    bVar.a.setImageDrawable(null);
                    bVar.a.startLoad(portrait, 12, false);
                    bVar.f25265b.setText(this.f25258e.get(i2).getName_show());
                    bVar.f25266c.setText(this.f25258e.get(i2).getIntro());
                    bVar.f25267d.setTag(Integer.valueOf(i2));
                }
            } else {
                bVar.f25265b.setText(this.f25259f.getPageContext().getString(c.a.s0.y2.g.loading));
                bVar.f25269f.setVisibility(0);
            }
            a(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (this.f25262i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
