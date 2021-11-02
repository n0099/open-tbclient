package b.a.r0.i3.j;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.BarFolderFirstDirActivity;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f18087e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f18088f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f18089g;

    /* renamed from: b.a.r0.i3.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0923a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18090e;

        public View$OnClickListenerC0923a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18090e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag();
                if ((tag instanceof b) && (dVar = ((b) tag).f18094d) != null) {
                    if (dVar.f18097a == null) {
                        BarFolderFirstDirActivity.k(this.f18090e.getContext(), null);
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f18090e.getContext(), dVar.f18098b, dVar.f18097a, dVar.f18099c)));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f18091a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18092b;

        /* renamed from: c  reason: collision with root package name */
        public BestStringsFitTextView f18093c;

        /* renamed from: d  reason: collision with root package name */
        public d f18094d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public a(Activity activity, b.a.r0.i3.j.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18089g = new View$OnClickListenerC0923a(this);
        this.f18087e = activity;
        this.f18088f = bVar.h();
    }

    public final View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 == 3) {
                return LayoutInflater.from(this.f18087e).inflate(R.layout.bar_home_list_line, viewGroup, false);
            }
            if (i2 == 2) {
                return LayoutInflater.from(this.f18087e).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
            }
            View inflate = LayoutInflater.from(this.f18087e).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
            inflate.setOnClickListener(this.f18089g);
            b bVar = new b();
            bVar.f18091a = (BarImageView) inflate.findViewById(R.id.portrait);
            bVar.f18092b = (TextView) inflate.findViewById(R.id.name);
            bVar.f18093c = (BestStringsFitTextView) inflate.findViewById(R.id.description);
            inflate.setTag(bVar);
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public final void b(ViewGroup viewGroup, b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, bVar, i2) == null) {
            d dVar = this.f18088f.get(i2 / 2);
            bVar.f18094d = dVar;
            bVar.f18092b.setText(dVar.f18098b);
            if (dVar.f18101e != null) {
                bVar.f18093c.setVisibility(0);
                String[] strArr = new String[dVar.f18101e.size()];
                for (int i3 = 0; i3 < dVar.f18101e.size(); i3++) {
                    strArr[i3] = dVar.f18101e.get(i3).f18098b;
                }
                bVar.f18093c.setTextArray(strArr);
            } else {
                bVar.f18093c.setVisibility(8);
            }
            if (dVar.f18100d != null) {
                int e2 = l.e(this.f18087e, 45.0f);
                bVar.f18091a.setTag(dVar.f18100d);
                bVar.f18091a.startLoad(dVar.f18100d, 10, e2, e2, false);
            }
        }
    }

    public ArrayList<d> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18088f : (ArrayList) invokeV.objValue;
    }

    public void d(ArrayList<d> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.f18088f = arrayList;
        }
    }

    public Activity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18087e : (Activity) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<d> arrayList = this.f18088f;
            if (arrayList == null) {
                return 0;
            }
            return (arrayList.size() * 2) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (getCount() <= 0 || i2 != getCount() - 1) {
                return Math.abs(i2) % 2 == 1 ? 3 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                view = a(viewGroup, itemViewType);
                ViewHelper.prepareNewView(view);
            }
            ViewHelper.processCurrentSkin(view);
            if (itemViewType == 3) {
                return view;
            }
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            SkinManager.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                b(viewGroup, (b) view.getTag(), i2);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }
}
