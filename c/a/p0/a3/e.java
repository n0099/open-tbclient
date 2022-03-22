package c.a.p0.a3;

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
/* loaded from: classes2.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<UserData> a;

    /* renamed from: b  reason: collision with root package name */
    public PersonFriendActivity f12136b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12137c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ProgressBar> f12138d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12139e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12140f;

    /* renamed from: g  reason: collision with root package name */
    public int f12141g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f12142h;
    public View.OnClickListener i;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f12143b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f12144c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f12145d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f12146e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f12147f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f12148g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f12149h;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personFriendActivity, Boolean.valueOf(z), Integer.valueOf(i), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f12136b = null;
        this.f12137c = false;
        this.f12139e = false;
        this.f12140f = true;
        this.f12141g = 0;
        this.f12142h = null;
        this.i = null;
        this.f12136b = personFriendActivity;
        this.f12138d = new ArrayList<>();
        this.f12140f = z;
        this.f12141g = i;
        this.f12142h = onClickListener;
        this.i = onClickListener2;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f12136b.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f12136b.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12139e = false;
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || arrayList.size() != 0) {
                return;
            }
            this.f12139e = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f12138d == null) {
            return;
        }
        for (int i = 0; i < this.f12138d.size(); i++) {
            try {
                this.f12138d.get(i).setVisibility(8);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        this.f12138d.clear();
    }

    public void d(ArrayList<UserData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f12137c = z;
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
            if (this.f12139e) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.a;
            int size = arrayList != null ? arrayList.size() : 0;
            return this.f12137c ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.f12139e) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.a;
            return (arrayList == null || i >= arrayList.size()) ? 1 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view, viewGroup)) == null) {
            if (this.a == null) {
                return view;
            }
            if (view == null) {
                bVar = new b(this, null);
                if (getItemViewType(i) == 0) {
                    view2 = LayoutInflater.from(this.f12136b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06cb, (ViewGroup) null);
                    HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091827);
                    bVar.a = headImageView;
                    headImageView.setIsRound(false);
                    bVar.a.setAutoChangeStyle(true);
                    bVar.f12146e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ef3);
                    bVar.f12143b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0914e9);
                    bVar.f12148g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902b2);
                    bVar.f12144c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f47);
                    bVar.f12145d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905f4);
                    bVar.f12149h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907d6);
                    bVar.f12145d.setOnClickListener(this.f12142h);
                } else {
                    view2 = LayoutInflater.from(this.f12136b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
                    bVar.f12143b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916ed);
                    view2.setOnClickListener(this.i);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091929);
                    bVar.f12147f = progressBar;
                    this.f12138d.add(progressBar);
                }
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.f12139e) {
                    bVar.f12146e.setVisibility(8);
                    bVar.f12145d.setVisibility(8);
                    bVar.f12148g.setVisibility(8);
                    bVar.f12149h.setVisibility(8);
                } else {
                    if (!this.f12140f && this.f12141g == 0) {
                        bVar.f12145d.setVisibility(8);
                    } else {
                        bVar.f12145d.setVisibility(0);
                    }
                    bVar.f12146e.setVisibility(0);
                    bVar.f12146e.setTag(Integer.valueOf(i));
                    bVar.f12149h.setVisibility(0);
                    bVar.f12148g.setVisibility(8);
                    String portrait = this.a.get(i).getPortrait();
                    bVar.a.setImageDrawable(null);
                    bVar.a.J(portrait, 12, false);
                    bVar.f12143b.setText(this.a.get(i).getName_show());
                    bVar.f12144c.setText(this.a.get(i).getIntro());
                    bVar.f12145d.setTag(Integer.valueOf(i));
                }
            } else {
                bVar.f12143b.setText(this.f12136b.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a2e));
                bVar.f12147f.setVisibility(0);
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
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (this.f12139e) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }
}
