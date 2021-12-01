package c.a.p0.a.y0.e.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.p0.a.e;
import c.a.p0.a.f;
import c.a.p0.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f8781e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f8782f;

    /* renamed from: c.a.p0.a.y0.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0527a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

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

        public /* synthetic */ b(C0527a c0527a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public c() {
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

        public /* synthetic */ c(C0527a c0527a) {
            this();
        }
    }

    public a(Context context, @NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8781e = context;
        this.f8782f = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8782f.length : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f8782f[i2] : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: c.a.p0.a.y0.e.e.a$b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        View inflate;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                if (i2 == 11) {
                    inflate = View.inflate(this.f8781e, g.aiapps_keyboard_img_item, null);
                    b bVar = new b(null);
                    bVar.a = (ImageView) inflate.findViewById(f.delete_key_img_view);
                    cVar2 = bVar;
                } else {
                    inflate = View.inflate(this.f8781e, g.aiapps_keyboard_text_item, null);
                    c cVar3 = new c(null);
                    cVar3.a = (TextView) inflate.findViewById(f.key_text_view);
                    cVar2 = cVar3;
                    if (i2 == 9) {
                        if (TextUtils.isEmpty(this.f8782f[9])) {
                            inflate.setBackgroundColor(this.f8781e.getResources().getColor(c.a.p0.a.c.aiapps_keyboard_non_number_item_background_normal));
                            cVar2 = cVar3;
                        } else {
                            inflate.setBackgroundResource(e.aiapps_keyboard_non_number_item_selector);
                            cVar2 = cVar3;
                        }
                    }
                }
                view = inflate;
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = view.getTag();
            }
            if (i2 != 11 && (cVar instanceof c)) {
                ((c) cVar).a.setText(this.f8782f[i2]);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
