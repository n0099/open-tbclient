package c.a.r0.o2;

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
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonFriendActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f23168e;

    /* renamed from: f  reason: collision with root package name */
    public PersonFriendActivity f23169f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23170g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f23171h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23172i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23173j;
    public int k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f23174a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f23175b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f23176c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f23177d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f23178e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f23179f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f23180g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f23181h;

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
        this.f23168e = null;
        this.f23169f = null;
        this.f23170g = false;
        this.f23172i = false;
        this.f23173j = true;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.f23169f = personFriendActivity;
        this.f23171h = new ArrayList<>();
        this.f23173j = z;
        this.k = i2;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f23169f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f23169f.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23172i = false;
            ArrayList<UserData> arrayList = this.f23168e;
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            this.f23172i = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f23171h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f23171h.size(); i2++) {
            try {
                this.f23171h.get(i2).setVisibility(8);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        this.f23171h.clear();
    }

    public void d(ArrayList<UserData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f23168e = arrayList;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f23170g = z;
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
            if (this.f23172i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f23168e;
            int size = arrayList != null ? arrayList.size() : 0;
            return this.f23170g ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f23168e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f23168e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f23168e;
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
            if (this.f23172i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f23168e;
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
            if (this.f23168e == null) {
                return view;
            }
            if (view == null) {
                bVar = new b(this, null);
                if (getItemViewType(i2) == 0) {
                    view2 = LayoutInflater.from(this.f23169f.getPageContext().getPageActivity()).inflate(R.layout.person_list_item_friend, (ViewGroup) null);
                    HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.photo);
                    bVar.f23174a = headImageView;
                    headImageView.setIsRound(false);
                    bVar.f23174a.setAutoChangeStyle(true);
                    bVar.f23178e = (LinearLayout) view2.findViewById(R.id.info);
                    bVar.f23175b = (TextView) view2.findViewById(R.id.name);
                    bVar.f23180g = (TextView) view2.findViewById(R.id.at_list_nodata);
                    bVar.f23176c = (TextView) view2.findViewById(R.id.intro);
                    bVar.f23177d = (ImageView) view2.findViewById(R.id.chat);
                    bVar.f23181h = (ImageView) view2.findViewById(R.id.diver_buttom_px);
                    bVar.f23177d.setOnClickListener(this.l);
                } else {
                    view2 = LayoutInflater.from(this.f23169f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    bVar.f23175b = (TextView) view2.findViewById(R.id.pb_more_text);
                    view2.setOnClickListener(this.m);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.progress);
                    bVar.f23179f = progressBar;
                    this.f23171h.add(progressBar);
                }
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i2) == 0) {
                if (this.f23172i) {
                    bVar.f23178e.setVisibility(8);
                    bVar.f23177d.setVisibility(8);
                    bVar.f23180g.setVisibility(8);
                    bVar.f23181h.setVisibility(8);
                } else {
                    if (!this.f23173j && this.k == 0) {
                        bVar.f23177d.setVisibility(8);
                    } else {
                        bVar.f23177d.setVisibility(0);
                    }
                    bVar.f23178e.setVisibility(0);
                    bVar.f23178e.setTag(Integer.valueOf(i2));
                    bVar.f23181h.setVisibility(0);
                    bVar.f23180g.setVisibility(8);
                    String portrait = this.f23168e.get(i2).getPortrait();
                    bVar.f23174a.setImageDrawable(null);
                    bVar.f23174a.startLoad(portrait, 12, false);
                    bVar.f23175b.setText(this.f23168e.get(i2).getName_show());
                    bVar.f23176c.setText(this.f23168e.get(i2).getIntro());
                    bVar.f23177d.setTag(Integer.valueOf(i2));
                }
            } else {
                bVar.f23175b.setText(this.f23169f.getPageContext().getString(R.string.loading));
                bVar.f23179f.setVisibility(0);
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
            if (this.f23172i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
