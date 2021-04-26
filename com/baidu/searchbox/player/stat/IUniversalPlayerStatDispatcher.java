package com.baidu.searchbox.player.stat;

import android.graphics.Point;
import com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher;
/* loaded from: classes2.dex */
public interface IUniversalPlayerStatDispatcher extends IPlayerStatisticsDispatcher {

    /* loaded from: classes2.dex */
    public static final class SimpleStatDispatcher implements IUniversalPlayerStatDispatcher {
        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void end(int i2) {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void endInitPlayer() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void endInitPlayerKernel() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void goBackOrForeground(boolean z, int i2) {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void onError(int i2, int i3, Object obj) {
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingClick(String str, Point point) {
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingDismiss(String str, Point point) {
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingScale(boolean z, String str, Point point) {
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingShow(String str, Point point) {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void onInfo(int i2, int i3, Object obj) {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void pause() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void release() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void resume() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void start() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void startInitPlayer() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void startInitPlayerKernel() {
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void stop(int i2) {
        }
    }

    void onFloatingClick(String str, Point point);

    void onFloatingDismiss(String str, Point point);

    void onFloatingScale(boolean z, String str, Point point);

    void onFloatingShow(String str, Point point);
}
