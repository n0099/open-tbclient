package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class RemoteInput {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    public static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    public static final String TAG = "RemoteInput";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mAllowFreeFormTextInput;
    public final Set<String> mAllowedDataTypes;
    public final CharSequence[] mChoices;
    public final int mEditChoicesBeforeSending;
    public final Bundle mExtras;
    public final CharSequence mLabel;
    public final String mResultKey;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Source {
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAllowFreeFormTextInput;
        public final Set<String> mAllowedDataTypes;
        public CharSequence[] mChoices;
        public int mEditChoicesBeforeSending;
        public final Bundle mExtras;
        public CharSequence mLabel;
        public final String mResultKey;

        public Builder(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if (str != null) {
                this.mResultKey = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        public Builder addExtras(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAllowFreeFormInput(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mAllowFreeFormTextInput = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setChoices(CharSequence[] charSequenceArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, charSequenceArr)) == null) {
                this.mChoices = charSequenceArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setEditChoicesBeforeSending(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.mEditChoicesBeforeSending = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setLabel(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
                this.mLabel = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public RemoteInput build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
            }
            return (RemoteInput) invokeV.objValue;
        }

        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mExtras;
            }
            return (Bundle) invokeV.objValue;
        }

        public Builder setAllowDataType(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
                if (z) {
                    this.mAllowedDataTypes.add(str);
                } else {
                    this.mAllowedDataTypes.remove(str);
                }
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }
    }

    public RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, charSequence, charSequenceArr, Boolean.valueOf(z), Integer.valueOf(i), bundle, set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResultKey = str;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArr;
        this.mAllowFreeFormTextInput = z;
        this.mEditChoicesBeforeSending = i;
        this.mExtras = bundle;
        this.mAllowedDataTypes = set;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, remoteInput, intent, map) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                android.app.RemoteInput.addDataResultToIntent(fromCompat(remoteInput), intent, map);
            } else if (i >= 16) {
                Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
                if (clipDataIntentFromIntent == null) {
                    clipDataIntentFromIntent = new Intent();
                }
                for (Map.Entry<String, Uri> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Uri value = entry.getValue();
                    if (key != null) {
                        Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(getExtraResultsKeyForData(key));
                        if (bundleExtra == null) {
                            bundleExtra = new Bundle();
                        }
                        bundleExtra.putString(remoteInput.getResultKey(), value.toString());
                        clipDataIntentFromIntent.putExtra(getExtraResultsKeyForData(key), bundleExtra);
                    }
                }
                intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
            }
        }
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, remoteInputArr, intent, bundle) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                android.app.RemoteInput.addResultsToIntent(fromCompat(remoteInputArr), intent, bundle);
                return;
            }
            if (i >= 20) {
                Bundle resultsFromIntent = getResultsFromIntent(intent);
                int resultsSource = getResultsSource(intent);
                if (resultsFromIntent != null) {
                    resultsFromIntent.putAll(bundle);
                    bundle = resultsFromIntent;
                }
                for (RemoteInput remoteInput : remoteInputArr) {
                    Map<String, Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput.getResultKey());
                    android.app.RemoteInput.addResultsToIntent(fromCompat(new RemoteInput[]{remoteInput}), intent, bundle);
                    if (dataResultsFromIntent != null) {
                        addDataResultToIntent(remoteInput, intent, dataResultsFromIntent);
                    }
                }
                setResultsSource(intent, resultsSource);
            } else if (i >= 16) {
                Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
                if (clipDataIntentFromIntent == null) {
                    clipDataIntentFromIntent = new Intent();
                }
                Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(EXTRA_RESULTS_DATA);
                if (bundleExtra == null) {
                    bundleExtra = new Bundle();
                }
                for (RemoteInput remoteInput2 : remoteInputArr) {
                    Object obj = bundle.get(remoteInput2.getResultKey());
                    if (obj instanceof CharSequence) {
                        bundleExtra.putCharSequence(remoteInput2.getResultKey(), (CharSequence) obj);
                    }
                }
                clipDataIntentFromIntent.putExtra(EXTRA_RESULTS_DATA, bundleExtra);
                intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
            }
        }
    }

    public static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, remoteInput)) == null) {
            RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 29) {
                addExtras.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
            }
            return addExtras.build();
        }
        return (android.app.RemoteInput) invokeL.objValue;
    }

    public static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, remoteInputArr)) == null) {
            if (remoteInputArr == null) {
                return null;
            }
            android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
            for (int i = 0; i < remoteInputArr.length; i++) {
                remoteInputArr2[i] = fromCompat(remoteInputArr[i]);
            }
            return remoteInputArr2;
        }
        return (android.app.RemoteInput[]) invokeL.objValue;
    }

    public static String getExtraResultsKeyForData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return EXTRA_DATA_TYPE_RESULTS_DATA + str;
        }
        return (String) invokeL.objValue;
    }

    public static Intent getClipDataIntentFromIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, intent)) == null) {
            ClipData clipData = intent.getClipData();
            if (clipData == null) {
                return null;
            }
            ClipDescription description = clipData.getDescription();
            if (!description.hasMimeType("text/vnd.android.intent") || !description.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) {
                return null;
            }
            return clipData.getItemAt(0).getIntent();
        }
        return (Intent) invokeL.objValue;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        InterceptResult invokeL;
        Intent clipDataIntentFromIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, intent)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 20) {
                return android.app.RemoteInput.getResultsFromIntent(intent);
            }
            if (i < 16 || (clipDataIntentFromIntent = getClipDataIntentFromIntent(intent)) == null) {
                return null;
            }
            return (Bundle) clipDataIntentFromIntent.getExtras().getParcelable(EXTRA_RESULTS_DATA);
        }
        return (Bundle) invokeL.objValue;
    }

    public static int getResultsSource(Intent intent) {
        InterceptResult invokeL;
        Intent clipDataIntentFromIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, intent)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return android.app.RemoteInput.getResultsSource(intent);
            }
            if (i < 16 || (clipDataIntentFromIntent = getClipDataIntentFromIntent(intent)) == null) {
                return 0;
            }
            return clipDataIntentFromIntent.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
        }
        return invokeL.intValue;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        InterceptResult invokeLL;
        Intent clipDataIntentFromIntent;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, intent, str)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
            }
            if (i < 16 || (clipDataIntentFromIntent = getClipDataIntentFromIntent(intent)) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str2 : clipDataIntentFromIntent.getExtras().keySet()) {
                if (str2.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA)) {
                    String substring = str2.substring(39);
                    if (!substring.isEmpty() && (string = clipDataIntentFromIntent.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                        hashMap.put(substring, Uri.parse(string));
                    }
                }
            }
            if (hashMap.isEmpty()) {
                return null;
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static void setResultsSource(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, intent, i) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                android.app.RemoteInput.setResultsSource(intent, i);
            } else if (i2 >= 16) {
                Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
                if (clipDataIntentFromIntent == null) {
                    clipDataIntentFromIntent = new Intent();
                }
                clipDataIntentFromIntent.putExtra(EXTRA_RESULTS_SOURCE, i);
                intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
            }
        }
    }

    public boolean getAllowFreeFormInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAllowFreeFormTextInput;
        }
        return invokeV.booleanValue;
    }

    public Set<String> getAllowedDataTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAllowedDataTypes;
        }
        return (Set) invokeV.objValue;
    }

    public CharSequence[] getChoices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mChoices;
        }
        return (CharSequence[]) invokeV.objValue;
    }

    public int getEditChoicesBeforeSending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mEditChoicesBeforeSending;
        }
        return invokeV.intValue;
    }

    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mExtras;
        }
        return (Bundle) invokeV.objValue;
    }

    public CharSequence getLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mLabel;
        }
        return (CharSequence) invokeV.objValue;
    }

    public String getResultKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mResultKey;
        }
        return (String) invokeV.objValue;
    }

    public boolean isDataOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!getAllowFreeFormInput() && ((getChoices() == null || getChoices().length == 0) && getAllowedDataTypes() != null && !getAllowedDataTypes().isEmpty())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
