package b.a.e.l.e;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c> f2430a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f2431b;

    /* renamed from: c  reason: collision with root package name */
    public a f2432c;

    /* loaded from: classes.dex */
    public interface a {
        void onPreLoad();
    }

    /* loaded from: classes.dex */
    public class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f2433a;

        /* renamed from: b  reason: collision with root package name */
        public int f2434b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f2435c;

        /* renamed from: d  reason: collision with root package name */
        public Object f2436d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2437e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2430a = null;
        this.f2431b = null;
        this.f2432c = null;
        this.f2430a = new ArrayList<>();
        this.f2431b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f2435c = new TypeAdapter.ViewHolder(view);
        cVar.f2436d = obj;
        cVar.f2437e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f2434b = id;
        cVar.f2433a = id;
        view.setTag("FOOTER");
        if (i2 >= 0 && i2 <= this.f2431b.size()) {
            this.f2431b.add(i2, cVar);
        } else {
            this.f2431b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f2435c = new TypeAdapter.ViewHolder(view);
        cVar.f2436d = obj;
        cVar.f2437e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f2434b = id;
        cVar.f2433a = id;
        view.setTag("HEADER");
        if (i2 >= 0 && i2 <= this.f2430a.size()) {
            this.f2430a.add(i2, cVar);
        } else {
            this.f2430a.add(cVar);
        }
    }

    public TypeAdapter.ViewHolder c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            TextView textView = new TextView(context);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
            int e2 = b.a.e.e.p.l.e(context, 15.0f);
            textView.setPadding(e2, e2, e2, e2);
            textView.setHeight(0);
            return new b(this, textView);
        }
        return (TypeAdapter.ViewHolder) invokeL.objValue;
    }

    public int d(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            for (int i2 = 0; i2 < this.f2431b.size(); i2++) {
                c cVar = this.f2431b.get(i2);
                if (cVar != null && (viewHolder = cVar.f2435c) != null && viewHolder.itemView == view) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public c e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Iterator<c> it = this.f2431b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i2 == next.f2434b) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public int f(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            for (int i2 = 0; i2 < this.f2430a.size(); i2++) {
                c cVar = this.f2430a.get(i2);
                if (cVar != null && (viewHolder = cVar.f2435c) != null && viewHolder.itemView == view) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            Iterator<c> it = this.f2430a.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i2 == next.f2434b) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2431b.size() : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2430a.size() : invokeV.intValue;
    }

    public boolean j(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2431b.size(); i2++) {
                c cVar = this.f2431b.get(i2);
                if (cVar != null && (viewHolder = cVar.f2435c) != null && viewHolder.itemView == view) {
                    this.f2431b.remove(i2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2430a.size(); i2++) {
                c cVar = this.f2430a.get(i2);
                if (cVar != null && (viewHolder = cVar.f2435c) != null && viewHolder.itemView == view) {
                    this.f2430a.remove(i2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f2432c = aVar;
        }
    }
}
