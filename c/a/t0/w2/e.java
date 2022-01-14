package c.a.t0.w2;

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
    public ArrayList<UserData> f24742e;

    /* renamed from: f  reason: collision with root package name */
    public PersonFriendActivity f24743f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24744g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ProgressBar> f24745h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24746i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24747j;
    public int k;
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
        public TextView f24748b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24749c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f24750d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f24751e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f24752f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24753g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f24754h;

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
        this.f24742e = null;
        this.f24743f = null;
        this.f24744g = false;
        this.f24746i = false;
        this.f24747j = true;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.f24743f = personFriendActivity;
        this.f24745h = new ArrayList<>();
        this.f24747j = z;
        this.k = i2;
        this.l = onClickListener;
        this.m = onClickListener2;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f24743f.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f24743f.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24746i = false;
            ArrayList<UserData> arrayList = this.f24742e;
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            this.f24746i = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f24745h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f24745h.size(); i2++) {
            try {
                this.f24745h.get(i2).setVisibility(8);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        this.f24745h.clear();
    }

    public void d(ArrayList<UserData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f24742e = arrayList;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f24744g = z;
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
            if (this.f24746i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f24742e;
            int size = arrayList != null ? arrayList.size() : 0;
            return this.f24744g ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f24742e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f24742e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f24742e;
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
            if (this.f24746i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f24742e;
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
            if (this.f24742e == null) {
                return view;
            }
            if (view == null) {
                bVar = new b(this, null);
                if (getItemViewType(i2) == 0) {
                    view2 = LayoutInflater.from(this.f24743f.getPageContext().getPageActivity()).inflate(c.a.t0.y2.e.person_list_item_friend, (ViewGroup) null);
                    HeadImageView headImageView = (HeadImageView) view2.findViewById(c.a.t0.y2.d.photo);
                    bVar.a = headImageView;
                    headImageView.setIsRound(false);
                    bVar.a.setAutoChangeStyle(true);
                    bVar.f24751e = (LinearLayout) view2.findViewById(c.a.t0.y2.d.info);
                    bVar.f24748b = (TextView) view2.findViewById(c.a.t0.y2.d.name);
                    bVar.f24753g = (TextView) view2.findViewById(c.a.t0.y2.d.at_list_nodata);
                    bVar.f24749c = (TextView) view2.findViewById(c.a.t0.y2.d.intro);
                    bVar.f24750d = (ImageView) view2.findViewById(c.a.t0.y2.d.chat);
                    bVar.f24754h = (ImageView) view2.findViewById(c.a.t0.y2.d.diver_buttom_px);
                    bVar.f24750d.setOnClickListener(this.l);
                } else {
                    view2 = LayoutInflater.from(this.f24743f.getPageContext().getPageActivity()).inflate(c.a.t0.y2.e.new_pb_list_more, (ViewGroup) null);
                    bVar.f24748b = (TextView) view2.findViewById(c.a.t0.y2.d.pb_more_text);
                    view2.setOnClickListener(this.m);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(c.a.t0.y2.d.progress);
                    bVar.f24752f = progressBar;
                    this.f24745h.add(progressBar);
                }
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i2) == 0) {
                if (this.f24746i) {
                    bVar.f24751e.setVisibility(8);
                    bVar.f24750d.setVisibility(8);
                    bVar.f24753g.setVisibility(8);
                    bVar.f24754h.setVisibility(8);
                } else {
                    if (!this.f24747j && this.k == 0) {
                        bVar.f24750d.setVisibility(8);
                    } else {
                        bVar.f24750d.setVisibility(0);
                    }
                    bVar.f24751e.setVisibility(0);
                    bVar.f24751e.setTag(Integer.valueOf(i2));
                    bVar.f24754h.setVisibility(0);
                    bVar.f24753g.setVisibility(8);
                    String portrait = this.f24742e.get(i2).getPortrait();
                    bVar.a.setImageDrawable(null);
                    bVar.a.startLoad(portrait, 12, false);
                    bVar.f24748b.setText(this.f24742e.get(i2).getName_show());
                    bVar.f24749c.setText(this.f24742e.get(i2).getIntro());
                    bVar.f24750d.setTag(Integer.valueOf(i2));
                }
            } else {
                bVar.f24748b.setText(this.f24743f.getPageContext().getString(c.a.t0.y2.g.loading));
                bVar.f24752f.setVisibility(0);
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
            if (this.f24746i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
