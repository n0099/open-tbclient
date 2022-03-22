package c.a.d.o.e;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
    public ArrayList<c> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f2580b;

    /* renamed from: c  reason: collision with root package name */
    public a f2581c;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f2582b;

        /* renamed from: c  reason: collision with root package name */
        public TypeAdapter.ViewHolder f2583c;

        /* renamed from: d  reason: collision with root package name */
        public Object f2584d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2585e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f2580b = null;
        this.f2581c = null;
        this.a = new ArrayList<>();
        this.f2580b = new ArrayList<>();
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f2583c = new TypeAdapter.ViewHolder(view);
        cVar.f2584d = obj;
        cVar.f2585e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f2582b = id;
        cVar.a = id;
        view.setTag("FOOTER");
        if (i >= 0 && i <= this.f2580b.size()) {
            this.f2580b.add(i, cVar);
        } else {
            this.f2580b.add(cVar);
        }
    }

    public void b(View view, Object obj, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.f2583c = new TypeAdapter.ViewHolder(view);
        cVar.f2584d = obj;
        cVar.f2585e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.f2582b = id;
        cVar.a = id;
        view.setTag("HEADER");
        if (i >= 0 && i <= this.a.size()) {
            this.a.add(i, cVar);
        } else {
            this.a.add(cVar);
        }
    }

    public TypeAdapter.ViewHolder c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            TextView textView = new TextView(context);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0a2d));
            int d2 = c.a.d.f.p.n.d(context, 15.0f);
            textView.setPadding(d2, d2, d2, d2);
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
            for (int i = 0; i < this.f2580b.size(); i++) {
                c cVar = this.f2580b.get(i);
                if (cVar != null && (viewHolder = cVar.f2583c) != null && viewHolder.itemView == view) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public c e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Iterator<c> it = this.f2580b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i == next.f2582b) {
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
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(i);
                if (cVar != null && (viewHolder = cVar.f2583c) != null && viewHolder.itemView == view) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Nullable
    public View g(@NonNull Object obj) {
        InterceptResult invokeL;
        View view;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(i);
                if (cVar != null && (tag = (view = cVar.f2583c.itemView).getTag(R.id.obfuscated_res_0x7f090f65)) != null && tag.equals(obj)) {
                    return view;
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public c h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            Iterator<c> it = this.a.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i == next.f2582b) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2580b.size() : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    public boolean k(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (view == null) {
                return false;
            }
            for (int i = 0; i < this.f2580b.size(); i++) {
                c cVar = this.f2580b.get(i);
                if (cVar != null && (viewHolder = cVar.f2583c) != null && viewHolder.itemView == view) {
                    this.f2580b.remove(i);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean l(View view) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view)) == null) {
            if (view == null) {
                return false;
            }
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(i);
                if (cVar != null && (viewHolder = cVar.f2583c) != null && viewHolder.itemView == view) {
                    this.a.remove(i);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f2581c = aVar;
        }
    }
}
