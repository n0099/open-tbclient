package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dh4;
import com.baidu.tieba.gh4;
import com.baidu.tieba.hh4;
import com.baidu.tieba.ih4;
import com.baidu.tieba.wg4;
import com.baidu.tieba.yg4;
import com.baidu.tieba.yh4;
import com.baidu.tieba.zg4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes3.dex */
public class FragmentActivity extends dh4 implements wg4.b, yg4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final gh4 b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    public void m(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fragment) == null) {
        }
    }

    public Object q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FragmentActivity a;

        public a(FragmentActivity fragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragmentActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        super.handleMessage(message);
                        return;
                    }
                    this.a.p();
                    this.a.b.v();
                    return;
                }
                FragmentActivity fragmentActivity = this.a;
                if (fragmentActivity.e) {
                    fragmentActivity.j(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends hh4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FragmentActivity j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = fragmentActivity;
        }

        @Override // com.baidu.tieba.hh4, com.baidu.tieba.fh4
        public View a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return this.j.findViewById(i);
            }
            return (View) invokeI.objValue;
        }

        @Override // com.baidu.tieba.hh4
        public void k(Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fragment) == null) {
                this.j.m(fragment);
            }
        }

        @Override // com.baidu.tieba.hh4
        public boolean q(Fragment fragment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fragment)) == null) {
                return !this.j.isFinishing();
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.hh4, com.baidu.tieba.fh4
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Window window = this.j.getWindow();
                if (window != null && window.peekDecorView() != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.hh4
        public LayoutInflater m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.j.getLayoutInflater().cloneInContext(this.j);
            }
            return (LayoutInflater) invokeV.objValue;
        }

        @Override // com.baidu.tieba.hh4
        public int n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Window window = this.j.getWindow();
                if (window == null) {
                    return 0;
                }
                return window.getAttributes().windowAnimations;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.hh4
        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.j.getWindow() != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.hh4
        public void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.j.u();
            }
        }

        @Override // com.baidu.tieba.hh4
        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, fileDescriptor, printWriter, strArr) == null) {
                this.j.dump(str, fileDescriptor, printWriter, strArr);
            }
        }

        @Override // com.baidu.tieba.hh4
        public void p(Fragment fragment, String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048583, this, fragment, strArr, i) == null) {
                this.j.r(fragment, strArr, i);
            }
        }

        @Override // com.baidu.tieba.hh4
        public void r(Fragment fragment, Intent intent, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048585, this, fragment, intent, i) == null) {
                this.j.s(fragment, intent, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public List b;
        public yh4 c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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

    public FragmentActivity() {
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
        this.a = new a(this);
        this.b = gh4.b(new b(this));
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.e) {
                j(true);
            }
            Object q = q();
            List F = this.b.F();
            yh4 E = this.b.E();
            if (F == null && E == null && q == null) {
                return null;
            }
            c cVar = new c();
            cVar.a = q;
            cVar.b = F;
            cVar.c = E;
            return cVar;
        }
        return invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStart();
            this.e = false;
            this.f = false;
            this.a.removeMessages(1);
            if (!this.c) {
                this.c = true;
                this.b.c();
            }
            this.b.z();
            this.b.v();
            this.b.s();
            this.b.p();
            this.b.B();
        }
    }

    @Override // com.baidu.tieba.ch4
    public final View h(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str, context, attributeSet)) == null) {
            return this.b.A(view2, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    public static String v(View view2) {
        InterceptResult invokeL;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(view2.getClass().getName());
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(view2)));
            sb.append(WebvttCueParser.CHAR_SPACE);
            int visibility = view2.getVisibility();
            char c9 = 'V';
            char c10 = IStringUtil.EXTENSION_SEPARATOR;
            if (visibility != 0) {
                if (visibility != 4) {
                    if (visibility != 8) {
                        sb.append(IStringUtil.EXTENSION_SEPARATOR);
                    } else {
                        sb.append('G');
                    }
                } else {
                    sb.append('I');
                }
            } else {
                sb.append('V');
            }
            char c11 = 'F';
            if (view2.isFocusable()) {
                c2 = 'F';
            } else {
                c2 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c2);
            if (view2.isEnabled()) {
                c3 = 'E';
            } else {
                c3 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c3);
            if (view2.willNotDraw()) {
                c4 = IStringUtil.EXTENSION_SEPARATOR;
            } else {
                c4 = 'D';
            }
            sb.append(c4);
            if (view2.isHorizontalScrollBarEnabled()) {
                c5 = 'H';
            } else {
                c5 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c5);
            if (!view2.isVerticalScrollBarEnabled()) {
                c9 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c9);
            if (view2.isClickable()) {
                c6 = 'C';
            } else {
                c6 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c6);
            if (view2.isLongClickable()) {
                c7 = 'L';
            } else {
                c7 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c7);
            sb.append(WebvttCueParser.CHAR_SPACE);
            if (!view2.isFocused()) {
                c11 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c11);
            if (view2.isSelected()) {
                c8 = 'S';
            } else {
                c8 = IStringUtil.EXTENSION_SEPARATOR;
            }
            sb.append(c8);
            if (view2.isPressed()) {
                c10 = 'P';
            }
            sb.append(c10);
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(view2.getLeft());
            sb.append(',');
            sb.append(view2.getTop());
            sb.append(SignatureImpl.SEP);
            sb.append(view2.getRight());
            sb.append(',');
            sb.append(view2.getBottom());
            int id = view2.getId();
            if (id != -1) {
                sb.append(" #");
                sb.append(Integer.toHexString(id));
                Resources resources = view2.getResources();
                if (id != 0 && resources != null) {
                    int i = (-16777216) & id;
                    if (i != 16777216) {
                        if (i != 2130706432) {
                            try {
                                str = resources.getResourcePackageName(id);
                            } catch (Resources.NotFoundException unused) {
                            }
                        } else {
                            str = "app";
                        }
                    } else {
                        str = "android";
                    }
                    String resourceTypeName = resources.getResourceTypeName(id);
                    String resourceEntryName = resources.getResourceEntryName(id);
                    sb.append(" ");
                    sb.append(str);
                    sb.append(":");
                    sb.append(resourceTypeName);
                    sb.append("/");
                    sb.append(resourceEntryName);
                }
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + GlideException.IndentedAppendable.INDENT;
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.c);
            printWriter.print("mResumed=");
            printWriter.print(this.d);
            printWriter.print(" mStopped=");
            printWriter.print(this.e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f);
            this.b.u(str2, fileDescriptor, printWriter, strArr);
            this.b.y().b(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            k(str + GlideException.IndentedAppendable.INDENT, printWriter, getWindow().getDecorView());
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !this.f) {
            this.f = true;
            this.g = z;
            this.a.removeMessages(1);
            o();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.b.d(configuration);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            this.b.z();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            Parcelable G = this.b.G();
            if (G != null) {
                bundle.putParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG, G);
            }
        }
    }

    @Override // com.baidu.tieba.yg4.a
    public final void validateRequestPermissionsRequestCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            if (this.i) {
                this.i = false;
            } else if ((i & (-256)) == 0) {
            } else {
                throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
            }
        }
    }

    public final void k(String str, PrintWriter printWriter, View view2) {
        ViewGroup viewGroup;
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, printWriter, view2) == null) {
            printWriter.print(str);
            if (view2 == null) {
                printWriter.println(StringUtil.NULL_STRING);
                return;
            }
            printWriter.println(v(view2));
            if (!(view2 instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view2).getChildCount()) <= 0) {
                return;
            }
            String str2 = str + GlideException.IndentedAppendable.INDENT;
            for (int i = 0; i < childCount; i++) {
                k(str2, printWriter, viewGroup.getChildAt(i));
            }
        }
    }

    public ih4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b.y();
        }
        return (ih4) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.t(this.g);
            this.b.n();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.b.y().f()) {
            t();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            j(false);
            this.b.h();
            this.b.r();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onLowMemory();
            this.b.i();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            this.d = false;
            if (this.a.hasMessages(2)) {
                this.a.removeMessages(2);
                p();
            }
            this.b.l();
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPostResume();
            this.a.removeMessages(2);
            p();
            this.b.v();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            this.a.sendEmptyMessage(2);
            this.d = true;
            this.b.v();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.b.z();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStop();
            this.e = true;
            this.a.sendEmptyMessage(1);
            this.b.q();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.b.o();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            wg4.e(this);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                zg4.a(this);
            } else {
                this.h = true;
            }
        }
    }

    public boolean n(View view2, Menu menu) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, menu)) == null) {
            return super.onPreparePanel(0, view2, menu);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, menu)) == null) {
            if (i == 0) {
                boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.b.g(menu, getMenuInflater());
                if (Build.VERSION.SDK_INT >= 11) {
                    return onCreatePanelMenu;
                }
                return true;
            }
            return super.onCreatePanelMenu(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, keyEvent)) == null) {
            if (Build.VERSION.SDK_INT < 5 && i == 4 && keyEvent.getRepeatCount() == 0) {
                onBackPressed();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i, menuItem)) == null) {
            if (super.onMenuItemSelected(i, menuItem)) {
                return true;
            }
            if (i != 0) {
                if (i != 6) {
                    return false;
                }
                return this.b.e(menuItem);
            }
            return this.b.j(menuItem);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, menu) == null) {
            if (i == 0) {
                this.b.k(menu);
            }
            super.onPanelClosed(i, menu);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, intent, i) == null) {
            if (i != -1 && ((-65536) & i) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
            super.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            this.b.z();
            int i3 = i >> 16;
            if (i3 != 0) {
                int i4 = i3 - 1;
                int x = this.b.x();
                if (x != 0 && i4 >= 0 && i4 < x) {
                    Fragment fragment = (Fragment) this.b.w(new ArrayList(x)).get(i4);
                    if (fragment == null) {
                        Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                        return;
                    }
                    fragment.q0(i & 65535, i2, intent);
                    return;
                }
                Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, com.baidu.tieba.wg4.b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048598, this, i, strArr, iArr) == null) && (i2 = (i >> 8) & 255) != 0) {
            int i3 = i2 - 1;
            int x = this.b.x();
            if (x != 0 && i3 >= 0 && i3 < x) {
                Fragment fragment = (Fragment) this.b.w(new ArrayList(x)).get(i3);
                if (fragment == null) {
                    Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                    return;
                }
                fragment.J0(i & 255, strArr, iArr);
                return;
            }
            Log.w(androidx.fragment.app.FragmentActivity.TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
        }
    }

    @Override // com.baidu.tieba.ch4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            List list = null;
            this.b.a(null);
            super.onCreate(bundle);
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.b.D(cVar.c);
            }
            if (bundle != null) {
                Parcelable parcelable = bundle.getParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG);
                gh4 gh4Var = this.b;
                if (cVar != null) {
                    list = cVar.b;
                }
                gh4Var.C(parcelable, list);
            }
            this.b.f();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view2, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048597, this, i, view2, menu)) == null) {
            if (i == 0 && menu != null) {
                if (this.h) {
                    this.h = false;
                    menu.clear();
                    onCreatePanelMenu(i, menu);
                }
                return n(view2, menu) | this.b.m(menu);
            }
            return super.onPreparePanel(i, view2, menu);
        }
        return invokeILL.booleanValue;
    }

    public final void r(Fragment fragment, String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048607, this, fragment, strArr, i) == null) {
            if (i == -1) {
                wg4.requestPermissions(this, strArr, i);
            } else if ((i & (-256)) == 0) {
                this.i = true;
                wg4.requestPermissions(this, strArr, ((fragment.f + 1) << 8) + (i & 255));
            } else {
                throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
            }
        }
    }

    public void s(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048608, this, fragment, intent, i) == null) {
            if (i == -1) {
                super.startActivityForResult(intent, -1);
            } else if (((-65536) & i) == 0) {
                super.startActivityForResult(intent, ((fragment.f + 1) << 16) + (i & 65535));
            } else {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
        }
    }
}
