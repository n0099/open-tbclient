package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ShareCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    public static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class IntentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ArrayList<String> mBccAddresses;
        @Nullable
        public ArrayList<String> mCcAddresses;
        @Nullable
        public CharSequence mChooserTitle;
        @NonNull
        public final Context mContext;
        @NonNull
        public final Intent mIntent;
        @Nullable
        public ArrayList<Uri> mStreams;
        @Nullable
        public ArrayList<String> mToAddresses;

        public IntentBuilder(@NonNull Context context, @Nullable ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, componentName};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = (Context) Preconditions.checkNotNull(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.mIntent = action;
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
            this.mIntent.addFlags(524288);
        }

        private void combineArrayExtra(String str, ArrayList<String> arrayList) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, str, arrayList) == null) {
                String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
                if (stringArrayExtra != null) {
                    i = stringArrayExtra.length;
                } else {
                    i = 0;
                }
                String[] strArr = new String[arrayList.size() + i];
                arrayList.toArray(strArr);
                if (stringArrayExtra != null) {
                    System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), i);
                }
                this.mIntent.putExtra(str, strArr);
            }
        }

        private void combineArrayExtra(@Nullable String str, @NonNull String[] strArr) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, str, strArr) == null) {
                Intent intent = getIntent();
                String[] stringArrayExtra = intent.getStringArrayExtra(str);
                if (stringArrayExtra != null) {
                    i = stringArrayExtra.length;
                } else {
                    i = 0;
                }
                String[] strArr2 = new String[strArr.length + i];
                if (stringArrayExtra != null) {
                    System.arraycopy(stringArrayExtra, 0, strArr2, 0, i);
                }
                System.arraycopy(strArr, 0, strArr2, i, strArr.length);
                intent.putExtra(str, strArr2);
            }
        }

        @NonNull
        public static IntentBuilder from(@NonNull Context context, @Nullable ComponentName componentName) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, componentName)) == null) {
                return new IntentBuilder(context, componentName);
            }
            return (IntentBuilder) invokeLL.objValue;
        }

        @NonNull
        public static IntentBuilder from(@NonNull Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
                return from((Context) Preconditions.checkNotNull(activity), activity.getComponentName());
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.mBccAddresses == null) {
                    this.mBccAddresses = new ArrayList<>();
                }
                this.mBccAddresses.add(str);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (this.mCcAddresses == null) {
                    this.mCcAddresses = new ArrayList<>();
                }
                this.mCcAddresses.add(str);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (this.mToAddresses == null) {
                    this.mToAddresses = new ArrayList<>();
                }
                this.mToAddresses.add(str);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                return setChooserTitle(this.mContext.getText(i));
            }
            return (IntentBuilder) invokeI.objValue;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, strArr)) == null) {
                this.mIntent.putExtra("android.intent.extra.BCC", strArr);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, strArr)) == null) {
                this.mIntent.putExtra("android.intent.extra.CC", strArr);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, strArr)) == null) {
                if (this.mToAddresses != null) {
                    this.mToAddresses = null;
                }
                this.mIntent.putExtra("android.intent.extra.EMAIL", strArr);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
                if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                    setText(Html.fromHtml(str));
                }
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, uri)) == null) {
                if (!"android.intent.action.SEND".equals(this.mIntent.getAction())) {
                    this.mIntent.setAction("android.intent.action.SEND");
                }
                this.mStreams = null;
                this.mIntent.putExtra("android.intent.extra.STREAM", uri);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
                this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.mIntent.setType(str);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                combineArrayExtra("android.intent.extra.BCC", strArr);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
                combineArrayExtra("android.intent.extra.CC", strArr);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
                combineArrayExtra("android.intent.extra.EMAIL", strArr);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) {
                this.mChooserTitle = charSequence;
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uri)) == null) {
                Uri uri2 = (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
                if (this.mStreams == null && uri2 == null) {
                    return setStream(uri);
                }
                if (this.mStreams == null) {
                    this.mStreams = new ArrayList<>();
                }
                if (uri2 != null) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                    this.mStreams.add(uri2);
                }
                this.mStreams.add(uri);
                return this;
            }
            return (IntentBuilder) invokeL.objValue;
        }

        @NonNull
        public Intent createChooserIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return Intent.createChooser(getIntent(), this.mChooserTitle);
            }
            return (Intent) invokeV.objValue;
        }

        @NonNull
        public Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mContext;
            }
            return (Context) invokeV.objValue;
        }

        public void startChooser() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                this.mContext.startActivity(createChooserIntent());
            }
        }

        @NonNull
        public Intent getIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                ArrayList<String> arrayList = this.mToAddresses;
                if (arrayList != null) {
                    combineArrayExtra("android.intent.extra.EMAIL", arrayList);
                    this.mToAddresses = null;
                }
                ArrayList<String> arrayList2 = this.mCcAddresses;
                if (arrayList2 != null) {
                    combineArrayExtra("android.intent.extra.CC", arrayList2);
                    this.mCcAddresses = null;
                }
                ArrayList<String> arrayList3 = this.mBccAddresses;
                if (arrayList3 != null) {
                    combineArrayExtra("android.intent.extra.BCC", arrayList3);
                    this.mBccAddresses = null;
                }
                ArrayList<Uri> arrayList4 = this.mStreams;
                boolean z = true;
                z = (arrayList4 == null || arrayList4.size() <= 1) ? false : false;
                boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
                if (!z && equals) {
                    this.mIntent.setAction("android.intent.action.SEND");
                    ArrayList<Uri> arrayList5 = this.mStreams;
                    if (arrayList5 != null && !arrayList5.isEmpty()) {
                        this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
                    } else {
                        this.mIntent.removeExtra("android.intent.extra.STREAM");
                    }
                    this.mStreams = null;
                }
                if (z && !equals) {
                    this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                    ArrayList<Uri> arrayList6 = this.mStreams;
                    if (arrayList6 != null && !arrayList6.isEmpty()) {
                        this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
                    } else {
                        this.mIntent.removeExtra("android.intent.extra.STREAM");
                    }
                }
                return this.mIntent;
            }
            return (Intent) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class IntentReader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "IntentReader";
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final ComponentName mCallingActivity;
        @Nullable
        public final String mCallingPackage;
        @NonNull
        public final Context mContext;
        @NonNull
        public final Intent mIntent;
        @Nullable
        public ArrayList<Uri> mStreams;

        public IntentReader(@NonNull Context context, @NonNull Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = (Context) Preconditions.checkNotNull(context);
            this.mIntent = (Intent) Preconditions.checkNotNull(intent);
            this.mCallingPackage = ShareCompat.getCallingPackage(intent);
            this.mCallingActivity = ShareCompat.getCallingActivity(intent);
        }

        @NonNull
        public static IntentReader from(@NonNull Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
                return from((Context) Preconditions.checkNotNull(activity), activity.getIntent());
            }
            return (IntentReader) invokeL.objValue;
        }

        @NonNull
        public static IntentReader from(@NonNull Context context, @NonNull Intent intent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
                return new IntentReader(context, intent);
            }
            return (IntentReader) invokeLL.objValue;
        }

        public static void withinStyle(StringBuilder sb, CharSequence charSequence, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65539, null, sb, charSequence, i, i2) == null) {
                while (i < i2) {
                    char charAt = charSequence.charAt(i);
                    if (charAt == '<') {
                        sb.append("&lt;");
                    } else if (charAt == '>') {
                        sb.append("&gt;");
                    } else if (charAt == '&') {
                        sb.append("&amp;");
                    } else if (charAt <= '~' && charAt >= ' ') {
                        if (charAt == ' ') {
                            while (true) {
                                int i3 = i + 1;
                                if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                                    break;
                                }
                                sb.append("&nbsp;");
                                i = i3;
                            }
                            sb.append(WebvttCueParser.CHAR_SPACE);
                        } else {
                            sb.append(charAt);
                        }
                    } else {
                        sb.append("&#");
                        sb.append((int) charAt);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                    i++;
                }
            }
        }

        @Nullable
        public ComponentName getCallingActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mCallingActivity;
            }
            return (ComponentName) invokeV.objValue;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mCallingActivity == null) {
                    return null;
                }
                try {
                    return this.mContext.getPackageManager().getActivityIcon(this.mCallingActivity);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(TAG, "Could not retrieve icon for calling activity", e);
                    return null;
                }
            }
            return (Drawable) invokeV.objValue;
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.mCallingPackage == null) {
                    return null;
                }
                try {
                    return this.mContext.getPackageManager().getApplicationIcon(this.mCallingPackage);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(TAG, "Could not retrieve icon for calling application", e);
                    return null;
                }
            }
            return (Drawable) invokeV.objValue;
        }

        @Nullable
        public String getCallingPackage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mCallingPackage;
            }
            return (String) invokeV.objValue;
        }

        @Nullable
        public String[] getEmailBcc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
            }
            return (String[]) invokeV.objValue;
        }

        @Nullable
        public String[] getEmailCc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
            }
            return (String[]) invokeV.objValue;
        }

        @Nullable
        public String[] getEmailTo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
            }
            return (String[]) invokeV.objValue;
        }

        @Nullable
        public Uri getStream() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            }
            return (Uri) invokeV.objValue;
        }

        @Nullable
        public String getSubject() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
            }
            return (String) invokeV.objValue;
        }

        @Nullable
        public CharSequence getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
            }
            return (CharSequence) invokeV.objValue;
        }

        @Nullable
        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.mIntent.getType();
            }
            return (String) invokeV.objValue;
        }

        public boolean isMultipleShare() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
            }
            return invokeV.booleanValue;
        }

        public boolean isShareIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                String action = this.mIntent.getAction();
                if (!"android.intent.action.SEND".equals(action) && !"android.intent.action.SEND_MULTIPLE".equals(action)) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean isSingleShare() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return "android.intent.action.SEND".equals(this.mIntent.getAction());
            }
            return invokeV.booleanValue;
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mCallingPackage == null) {
                    return null;
                }
                PackageManager packageManager = this.mContext.getPackageManager();
                try {
                    return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(TAG, "Could not retrieve label for calling application", e);
                    return null;
                }
            }
            return (CharSequence) invokeV.objValue;
        }

        public int getStreamCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.mStreams == null && isMultipleShare()) {
                    this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
                ArrayList<Uri> arrayList = this.mStreams;
                if (arrayList != null) {
                    return arrayList.size();
                }
                return this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
            }
            return invokeV.intValue;
        }

        @Nullable
        public String getHtmlText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                String stringExtra = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
                if (stringExtra == null) {
                    CharSequence text = getText();
                    if (text instanceof Spanned) {
                        return Html.toHtml((Spanned) text);
                    }
                    if (text != null) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            return Html.escapeHtml(text);
                        }
                        StringBuilder sb = new StringBuilder();
                        withinStyle(sb, text, 0, text.length());
                        return sb.toString();
                    }
                    return stringExtra;
                }
                return stringExtra;
            }
            return (String) invokeV.objValue;
        }

        @Nullable
        public Uri getStream(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                if (this.mStreams == null && isMultipleShare()) {
                    this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
                ArrayList<Uri> arrayList = this.mStreams;
                if (arrayList != null) {
                    return arrayList.get(i);
                }
                if (i == 0) {
                    return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
                }
                throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
            }
            return (Uri) invokeI.objValue;
        }
    }

    public ShareCompat() {
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

    public static void configureMenuItem(@NonNull Menu menu, @IdRes int i, @NonNull IntentBuilder intentBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, menu, i, intentBuilder) == null) {
            MenuItem findItem = menu.findItem(i);
            if (findItem != null) {
                configureMenuItem(findItem, intentBuilder);
                return;
            }
            throw new IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
        }
    }

    public static void configureMenuItem(@NonNull MenuItem menuItem, @NonNull IntentBuilder intentBuilder) {
        ShareActionProvider shareActionProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, menuItem, intentBuilder) == null) {
            ActionProvider actionProvider = menuItem.getActionProvider();
            if (!(actionProvider instanceof ShareActionProvider)) {
                shareActionProvider = new ShareActionProvider(intentBuilder.getContext());
            } else {
                shareActionProvider = (ShareActionProvider) actionProvider;
            }
            shareActionProvider.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + intentBuilder.getContext().getClass().getName());
            shareActionProvider.setShareIntent(intentBuilder.getIntent());
            menuItem.setActionProvider(shareActionProvider);
            if (Build.VERSION.SDK_INT < 16 && !menuItem.hasSubMenu()) {
                menuItem.setIntent(intentBuilder.createChooserIntent());
            }
        }
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            Intent intent = activity.getIntent();
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity == null) {
                return getCallingActivity(intent);
            }
            return callingActivity;
        }
        return (ComponentName) invokeL.objValue;
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            Intent intent = activity.getIntent();
            String callingPackage = activity.getCallingPackage();
            if (callingPackage == null && intent != null) {
                return getCallingPackage(intent);
            }
            return callingPackage;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, intent)) == null) {
            ComponentName componentName = (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
            if (componentName == null) {
                return (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
            }
            return componentName;
        }
        return (ComponentName) invokeL.objValue;
    }

    @Nullable
    public static String getCallingPackage(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, intent)) == null) {
            String stringExtra = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
            if (stringExtra == null) {
                return intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
            }
            return stringExtra;
        }
        return (String) invokeL.objValue;
    }
}
