package com.baidu.swan.apps.adaptation.interfaces.apkfetcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.c83;
import com.baidu.tieba.wt1;
/* loaded from: classes3.dex */
public interface ISwanApkFetcher {

    /* loaded from: classes3.dex */
    public enum FetchStates {
        PENDING,
        FETCHING,
        FETCH_PAUSED,
        FETCHED,
        FETCH_FAILED,
        INSTALLED,
        DELETED,
        FETCH_PREPARE,
        WAITING,
        FINISHED
    }

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public static class b extends c83 implements ISwanApkFetcher {
        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public boolean D() {
            return false;
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void F(@NonNull String str, @Nullable a aVar) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void d(@NonNull String str, @NonNull wt1 wt1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void e(@NonNull String str, @NonNull wt1 wt1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void f(@NonNull String str, @NonNull wt1 wt1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void g(@NonNull String str, @Nullable a aVar) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void h(@NonNull String str, @NonNull wt1 wt1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void j(@NonNull String str, @NonNull wt1 wt1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void release() {
        }
    }

    boolean D();

    void F(@NonNull String str, @Nullable a aVar);

    void d(@NonNull String str, @NonNull wt1 wt1Var);

    void e(@NonNull String str, @NonNull wt1 wt1Var);

    void f(@NonNull String str, @NonNull wt1 wt1Var);

    void g(@NonNull String str, @Nullable a aVar);

    void h(@NonNull String str, @NonNull wt1 wt1Var);

    void j(@NonNull String str, @NonNull wt1 wt1Var);

    void release();
}
