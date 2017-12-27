package android.support.v4.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.v4.app.RemoteInputCompatBase;
import android.util.Log;
/* loaded from: classes2.dex */
public final class RemoteInput extends RemoteInputCompatBase.RemoteInput {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    @RestrictTo
    public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY;
    private static final Impl IMPL;
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private final boolean mAllowFreeFormInput;
    private final CharSequence[] mChoices;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    /* loaded from: classes2.dex */
    interface Impl {
        void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);

        Bundle getResultsFromIntent(Intent intent);
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.mResultKey = str;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArr;
        this.mAllowFreeFormInput = z;
        this.mExtras = bundle;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public String getResultKey() {
        return this.mResultKey;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public CharSequence getLabel() {
        return this.mLabel;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormInput;
    }

    @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput
    public Bundle getExtras() {
        return this.mExtras;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private CharSequence[] mChoices;
        private CharSequence mLabel;
        private final String mResultKey;
        private boolean mAllowFreeFormInput = true;
        private Bundle mExtras = new Bundle();

        public Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.mResultKey = str;
        }

        public Builder setLabel(CharSequence charSequence) {
            this.mLabel = charSequence;
            return this;
        }

        public Builder setChoices(CharSequence[] charSequenceArr) {
            this.mChoices = charSequenceArr;
            return this;
        }

        public Builder setAllowFreeFormInput(boolean z) {
            this.mAllowFreeFormInput = z;
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            return this;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
        }
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return IMPL.getResultsFromIntent(intent);
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        IMPL.addResultsToIntent(remoteInputArr, intent, bundle);
    }

    /* loaded from: classes2.dex */
    static class ImplBase implements Impl {
        ImplBase() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public Bundle getResultsFromIntent(Intent intent) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
            return null;
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        }
    }

    /* loaded from: classes2.dex */
    static class ImplJellybean implements Impl {
        ImplJellybean() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatJellybean.getResultsFromIntent(intent);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatJellybean.addResultsToIntent(remoteInputArr, intent, bundle);
        }
    }

    /* loaded from: classes2.dex */
    static class ImplApi20 implements Impl {
        ImplApi20() {
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatApi20.getResultsFromIntent(intent);
        }

        @Override // android.support.v4.app.RemoteInput.Impl
        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatApi20.addResultsToIntent(remoteInputArr, intent, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            IMPL = new ImplApi20();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new ImplJellybean();
        } else {
            IMPL = new ImplBase();
        }
        FACTORY = new RemoteInputCompatBase.RemoteInput.Factory() { // from class: android.support.v4.app.RemoteInput.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory
            public RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
                return new RemoteInput(str, charSequence, charSequenceArr, z, bundle);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory
            public RemoteInput[] newArray(int i) {
                return new RemoteInput[i];
            }
        };
    }
}
