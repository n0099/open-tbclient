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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.repackage.ce4;
import com.repackage.de4;
import com.repackage.ee4;
import com.repackage.ie4;
import com.repackage.le4;
import com.repackage.sd4;
import com.repackage.ud4;
import com.repackage.vd4;
import com.repackage.ve4;
import com.repackage.zd4;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes2.dex */
public class FragmentActivity extends zd4 implements sd4.b, ud4.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final int HONEYCOMB = 11;
    public static final int MSG_REALLY_STOPPED = 1;
    public static final int MSG_RESUME_PENDING = 2;
    public static final String TAG = "FragmentActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCreated;
    public final ce4 mFragments;
    public final Handler mHandler;
    public boolean mOptionsMenuInvalidated;
    public boolean mReallyStopped;
    public boolean mRequestedPermissionsFromFragment;
    public boolean mResumed;
    public boolean mRetaining;
    public boolean mStopped;

    /* loaded from: classes2.dex */
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
                if (i == 1) {
                    FragmentActivity fragmentActivity = this.a;
                    if (fragmentActivity.mStopped) {
                        fragmentActivity.doReallyStop(false);
                    }
                } else if (i != 2) {
                    super.handleMessage(message);
                } else {
                    this.a.onResumeFragments();
                    this.a.mFragments.v();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends de4<FragmentActivity> {
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

        @Override // com.repackage.de4, com.repackage.be4
        @Nullable
        public View a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.j.findViewById(i) : (View) invokeI.objValue;
        }

        @Override // com.repackage.de4, com.repackage.be4
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Window window = this.j.getWindow();
                return (window == null || window.peekDecorView() == null) ? false : true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.de4
        public void l(Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fragment) == null) {
                this.j.onAttachFragment(fragment);
            }
        }

        @Override // com.repackage.de4
        public void m(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, fileDescriptor, printWriter, strArr) == null) {
                this.j.dump(str, fileDescriptor, printWriter, strArr);
            }
        }

        @Override // com.repackage.de4
        public LayoutInflater n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j.getLayoutInflater().cloneInContext(this.j) : (LayoutInflater) invokeV.objValue;
        }

        @Override // com.repackage.de4
        public int o() {
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

        @Override // com.repackage.de4
        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j.getWindow() != null : invokeV.booleanValue;
        }

        @Override // com.repackage.de4
        public void q(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048583, this, fragment, strArr, i) == null) {
                this.j.requestPermissionsFromFragment(fragment, strArr, i);
            }
        }

        @Override // com.repackage.de4
        public boolean r(Fragment fragment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fragment)) == null) ? !this.j.isFinishing() : invokeL.booleanValue;
        }

        @Override // com.repackage.de4
        public void s(Fragment fragment, Intent intent, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048585, this, fragment, intent, i) == null) {
                this.j.startActivityFromFragment(fragment, intent, i);
            }
        }

        @Override // com.repackage.de4
        public void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.j.supportInvalidateOptionsMenu();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public List<Fragment> b;
        public ve4<String, ie4> c;

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
        this.mHandler = new a(this);
        this.mFragments = ce4.b(new b(this));
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view2) {
        ViewGroup viewGroup;
        int childCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, str, printWriter, view2) == null) {
            printWriter.print(str);
            if (view2 == null) {
                printWriter.println(StringUtil.NULL_STRING);
                return;
            }
            printWriter.println(viewToString(view2));
            if ((view2 instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view2).getChildCount()) > 0) {
                String str2 = str + GlideException.IndentedAppendable.INDENT;
                for (int i = 0; i < childCount; i++) {
                    dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, fragment, strArr, i) == null) {
            if (i == -1) {
                sd4.requestPermissions(this, strArr, i);
            } else if ((i & (-256)) == 0) {
                this.mRequestedPermissionsFromFragment = true;
                sd4.requestPermissions(this, strArr, ((fragment.f + 1) << 8) + (i & 255));
            } else {
                throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
            }
        }
    }

    public static String viewToString(View view2) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(view2.getClass().getName());
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(view2)));
            sb.append(WebvttCueParser.CHAR_SPACE);
            int visibility = view2.getVisibility();
            char c2 = IStringUtil.EXTENSION_SEPARATOR;
            if (visibility == 0) {
                sb.append('V');
            } else if (visibility == 4) {
                sb.append('I');
            } else if (visibility != 8) {
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
            } else {
                sb.append('G');
            }
            sb.append(view2.isFocusable() ? 'F' : IStringUtil.EXTENSION_SEPARATOR);
            sb.append(view2.isEnabled() ? 'E' : IStringUtil.EXTENSION_SEPARATOR);
            sb.append(view2.willNotDraw() ? IStringUtil.EXTENSION_SEPARATOR : 'D');
            sb.append(view2.isHorizontalScrollBarEnabled() ? 'H' : IStringUtil.EXTENSION_SEPARATOR);
            sb.append(view2.isVerticalScrollBarEnabled() ? 'V' : IStringUtil.EXTENSION_SEPARATOR);
            sb.append(view2.isClickable() ? 'C' : IStringUtil.EXTENSION_SEPARATOR);
            sb.append(view2.isLongClickable() ? 'L' : IStringUtil.EXTENSION_SEPARATOR);
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(view2.isFocused() ? 'F' : IStringUtil.EXTENSION_SEPARATOR);
            sb.append(view2.isSelected() ? 'S' : IStringUtil.EXTENSION_SEPARATOR);
            if (view2.isPressed()) {
                c2 = 'P';
            }
            sb.append(c2);
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
                    if (i == 16777216) {
                        str = "android";
                    } else if (i != 2130706432) {
                        try {
                            str = resources.getResourcePackageName(id);
                        } catch (Resources.NotFoundException unused) {
                        }
                    } else {
                        str = "app";
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

    @Override // com.repackage.yd4
    public final View dispatchFragmentsOnCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, view2, str, context, attributeSet)) == null) ? this.mFragments.B(view2, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    public void doReallyStop(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.mReallyStopped) {
            return;
        }
        this.mReallyStopped = true;
        this.mRetaining = z;
        this.mHandler.removeMessages(1);
        onReallyStop();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + GlideException.IndentedAppendable.INDENT;
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print("mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.mReallyStopped);
            this.mFragments.u(str2, fileDescriptor, printWriter, strArr);
            this.mFragments.y().b(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            dumpViewHierarchy(str + GlideException.IndentedAppendable.INDENT, printWriter, getWindow().getDecorView());
        }
    }

    public Object getLastCustomNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                return cVar.a;
            }
            return null;
        }
        return invokeV.objValue;
    }

    public ee4 getSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFragments.y() : (ee4) invokeV.objValue;
    }

    public ie4 getSupportLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFragments.z() : (ie4) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
            this.mFragments.A();
            int i3 = i >> 16;
            if (i3 != 0) {
                int i4 = i3 - 1;
                int x = this.mFragments.x();
                if (x != 0 && i4 >= 0 && i4 < x) {
                    Fragment fragment = this.mFragments.w(new ArrayList(x)).get(i4);
                    if (fragment == null) {
                        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                        return;
                    }
                    fragment.r0(i & 65535, i2, intent);
                    return;
                }
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fragment) == null) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.mFragments.y().f()) {
            return;
        }
        supportFinishAfterTransition();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mFragments.d(configuration);
        }
    }

    @Override // com.repackage.yd4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            this.mFragments.a(null);
            super.onCreate(bundle);
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.mFragments.E(cVar.c);
            }
            if (bundle != null) {
                this.mFragments.D(bundle.getParcelable("android:support:fragments"), cVar != null ? cVar.b : null);
            }
            this.mFragments.f();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, menu)) == null) {
            if (i == 0) {
                boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.g(menu, getMenuInflater());
                if (Build.VERSION.SDK_INT >= 11) {
                    return onCreatePanelMenu;
                }
                return true;
            }
            return super.onCreatePanelMenu(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.zd4, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view2, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            doReallyStop(false);
            this.mFragments.h();
            this.mFragments.r();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, keyEvent)) == null) {
            if (Build.VERSION.SDK_INT < 5 && i == 4 && keyEvent.getRepeatCount() == 0) {
                onBackPressed();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onLowMemory();
            this.mFragments.i();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, menuItem)) == null) {
            if (super.onMenuItemSelected(i, menuItem)) {
                return true;
            }
            if (i != 0) {
                if (i != 6) {
                    return false;
                }
                return this.mFragments.e(menuItem);
            }
            return this.mFragments.j(menuItem);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            super.onNewIntent(intent);
            this.mFragments.A();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, menu) == null) {
            if (i == 0) {
                this.mFragments.k(menu);
            }
            super.onPanelClosed(i, menu);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPause();
            this.mResumed = false;
            if (this.mHandler.hasMessages(2)) {
                this.mHandler.removeMessages(2);
                onResumeFragments();
            }
            this.mFragments.l();
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPostResume();
            this.mHandler.removeMessages(2);
            onResumeFragments();
            this.mFragments.v();
        }
    }

    public boolean onPrepareOptionsPanel(View view2, Menu menu) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, view2, menu)) == null) ? super.onPreparePanel(0, view2, menu) : invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view2, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048599, this, i, view2, menu)) == null) {
            if (i == 0 && menu != null) {
                if (this.mOptionsMenuInvalidated) {
                    this.mOptionsMenuInvalidated = false;
                    menu.clear();
                    onCreatePanelMenu(i, menu);
                }
                return onPrepareOptionsPanel(view2, menu) | this.mFragments.m(menu);
            }
            return super.onPreparePanel(i, view2, menu);
        }
        return invokeILL.booleanValue;
    }

    public void onReallyStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mFragments.t(this.mRetaining);
            this.mFragments.n();
        }
    }

    @Override // android.app.Activity, com.repackage.sd4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048601, this, i, strArr, iArr) == null) || (i2 = (i >> 8) & 255) == 0) {
            return;
        }
        int i3 = i2 - 1;
        int x = this.mFragments.x();
        if (x != 0 && i3 >= 0 && i3 < x) {
            Fragment fragment = this.mFragments.w(new ArrayList(x)).get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            }
            fragment.J0(i & 255, strArr, iArr);
            return;
        }
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onResume();
            this.mHandler.sendEmptyMessage(2);
            this.mResumed = true;
            this.mFragments.v();
        }
    }

    public void onResumeFragments() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mFragments.o();
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.mStopped) {
                doReallyStop(true);
            }
            Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
            List<Fragment> G = this.mFragments.G();
            ve4<String, ie4> F = this.mFragments.F();
            if (G == null && F == null && onRetainCustomNonConfigurationInstance == null) {
                return null;
            }
            c cVar = new c();
            cVar.a = onRetainCustomNonConfigurationInstance;
            cVar.b = G;
            cVar.c = F;
            return cVar;
        }
        return invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            Parcelable H = this.mFragments.H();
            if (H != null) {
                bundle.putParcelable("android:support:fragments", H);
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onStart();
            this.mStopped = false;
            this.mReallyStopped = false;
            this.mHandler.removeMessages(1);
            if (!this.mCreated) {
                this.mCreated = true;
                this.mFragments.c();
            }
            this.mFragments.A();
            this.mFragments.v();
            this.mFragments.s();
            this.mFragments.p();
            this.mFragments.C();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.mFragments.A();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onStop();
            this.mStopped = true;
            this.mHandler.sendEmptyMessage(1);
            this.mFragments.q();
        }
    }

    public void setEnterSharedElementCallback(le4 le4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, le4Var) == null) {
            sd4.h(this, le4Var);
        }
    }

    public void setExitSharedElementCallback(le4 le4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, le4Var) == null) {
            sd4.i(this, le4Var);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, intent, i) == null) {
            if (i != -1 && ((-65536) & i) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
            super.startActivityForResult(intent, i);
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048613, this, fragment, intent, i) == null) {
            if (i == -1) {
                super.startActivityForResult(intent, -1);
            } else if (((-65536) & i) == 0) {
                super.startActivityForResult(intent, ((fragment.f + 1) << 16) + (i & 65535));
            } else {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
        }
    }

    public void supportFinishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            sd4.f(this);
        }
    }

    public void supportInvalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                vd4.a(this);
            } else {
                this.mOptionsMenuInvalidated = true;
            }
        }
    }

    public void supportPostponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            sd4.g(this);
        }
    }

    public void supportStartPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            sd4.k(this);
        }
    }

    @Override // com.repackage.ud4.a
    public final void validateRequestPermissionsRequestCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            if (this.mRequestedPermissionsFromFragment) {
                this.mRequestedPermissionsFromFragment = false;
            } else if ((i & (-256)) != 0) {
                throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
            }
        }
    }

    @Override // com.repackage.yd4, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }
}
