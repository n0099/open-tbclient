package com.baidu.swan.apps.adaptation.interfaces.apkfetcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.sr1;
import com.baidu.tieba.x53;
/* loaded from: classes4.dex */
public interface ISwanApkFetcher {

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public static class b extends x53 implements ISwanApkFetcher {
        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public boolean D() {
            return false;
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void F(@NonNull String str, @Nullable a aVar) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void d(@NonNull String str, @NonNull sr1 sr1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void e(@NonNull String str, @NonNull sr1 sr1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void f(@NonNull String str, @NonNull sr1 sr1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void g(@NonNull String str, @Nullable a aVar) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void h(@NonNull String str, @NonNull sr1 sr1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void j(@NonNull String str, @NonNull sr1 sr1Var) {
        }

        @Override // com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher
        public void release() {
        }
    }

    boolean D();

    void F(@NonNull String str, @Nullable a aVar);

    void d(@NonNull String str, @NonNull sr1 sr1Var);

    void e(@NonNull String str, @NonNull sr1 sr1Var);

    void f(@NonNull String str, @NonNull sr1 sr1Var);

    void g(@NonNull String str, @Nullable a aVar);

    void h(@NonNull String str, @NonNull sr1 sr1Var);

    void j(@NonNull String str, @NonNull sr1 sr1Var);

    void release();
}
