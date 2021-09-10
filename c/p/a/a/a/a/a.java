package c.p.a.a.a.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.p.a.a.a.c.k;
import c.p.a.a.a.d.d;
import c.p.a.a.a.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.p.a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class DialogInterface$OnClickListenerC1517a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.f.c f34416e;

        public DialogInterface$OnClickListenerC1517a(c.p.a.a.a.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34416e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.InterfaceC1519c interfaceC1519c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC1519c = this.f34416e.f34454h) == null) {
                return;
            }
            interfaceC1519c.b(dialogInterface);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.f.c f34417e;

        public b(c.p.a.a.a.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34417e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.InterfaceC1519c interfaceC1519c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC1519c = this.f34417e.f34454h) == null) {
                return;
            }
            interfaceC1519c.a(dialogInterface);
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.f.c f34418e;

        public c(c.p.a.a.a.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34418e = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            c.InterfaceC1519c interfaceC1519c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (interfaceC1519c = this.f34418e.f34454h) == null) {
                return;
            }
            interfaceC1519c.c(dialogInterface);
        }
    }

    public a() {
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

    @Override // c.p.a.a.a.c.k
    public void a(int i2, @Nullable Context context, d dVar, String str, Drawable drawable, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), context, dVar, str, drawable, Integer.valueOf(i3)}) == null) {
            Toast.makeText(context, str, 0).show();
        }
    }

    @Override // c.p.a.a.a.c.k
    public Dialog b(@NonNull c.p.a.a.a.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? a(cVar) : (Dialog) invokeL.objValue;
    }

    public static Dialog a(c.p.a.a.a.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            AlertDialog show = new AlertDialog.Builder(cVar.f34447a).setTitle(cVar.f34448b).setMessage(cVar.f34449c).setPositiveButton(cVar.f34450d, new b(cVar)).setNegativeButton(cVar.f34451e, new DialogInterface$OnClickListenerC1517a(cVar)).show();
            show.setCanceledOnTouchOutside(cVar.f34452f);
            show.setOnCancelListener(new c(cVar));
            Drawable drawable = cVar.f34453g;
            if (drawable != null) {
                show.setIcon(drawable);
            }
            return show;
        }
        return (Dialog) invokeL.objValue;
    }
}
